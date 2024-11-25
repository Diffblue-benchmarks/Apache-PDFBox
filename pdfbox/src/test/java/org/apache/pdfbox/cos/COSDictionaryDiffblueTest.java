package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Map;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSDictionaryDiffblueTest {
  /**
   * Test {@link COSDictionary#COSDictionary()}.
   * <p>
   * Method under test: {@link COSDictionary#COSDictionary()}
   */
  @Test
  @DisplayName("Test new COSDictionary()")
  void testNewCOSDictionary() {
    // Arrange and Act
    COSDictionary actualCosDictionary = new COSDictionary();

    // Assert
    COSUpdateState updateState = actualCosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosDictionary.getKey());
    assertEquals(0, actualCosDictionary.size());
    COSIncrement toIncrementResult = actualCosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosDictionary.isDirect());
    assertFalse(actualCosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCosDictionary.getValues().isEmpty());
    assertTrue(actualCosDictionary.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#COSDictionary(COSDictionary)}.
   * <ul>
   *   <li>Then return UpdateState OriginDocumentState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#COSDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new COSDictionary(COSDictionary); then return UpdateState OriginDocumentState is 'null'")
  void testNewCOSDictionary_thenReturnUpdateStateOriginDocumentStateIsNull() {
    // Arrange and Act
    COSDictionary actualCosDictionary = new COSDictionary(new COSDictionary());

    // Assert
    COSUpdateState updateState = actualCosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosDictionary.getKey());
    assertEquals(0, actualCosDictionary.size());
    COSIncrement toIncrementResult = actualCosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosDictionary.isDirect());
    assertFalse(actualCosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCosDictionary.getValues().isEmpty());
    assertTrue(actualCosDictionary.items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#COSDictionary(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#COSDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new COSDictionary(COSDictionary); when COSStream(); then return Values size is one")
  void testNewCOSDictionary_whenCOSStream_thenReturnValuesSizeIsOne() {
    // Arrange and Act
    COSDictionary actualCosDictionary = new COSDictionary(new COSStream());

    // Assert
    assertEquals(1, actualCosDictionary.getValues().size());
    assertEquals(1, actualCosDictionary.items.size());
    assertEquals(1, actualCosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object)")
  void testContainsValue() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertTrue(cosStream.containsValue(new COSObject(COSInteger.OUT_OF_RANGE_MIN, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); given COSDictionary()")
  void testContainsValue_givenCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act and Assert
    assertFalse(cosDictionary.containsValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); given COSDictionary(); when 'Value'; then return 'false'")
  void testContainsValue_givenCOSDictionary_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).containsValue("Value"));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} addAll
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSFloat#ONE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); given COSStream() addAll COSDictionary(); when ONE; then return 'false'")
  void testContainsValue_givenCOSStreamAddAllCOSDictionary_whenOne_thenReturnFalse() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsValue(COSFloat.ONE));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} addAll
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); given COSStream() addAll COSDictionary(); when ONE; then return 'false'")
  void testContainsValue_givenCOSStreamAddAllCOSDictionary_whenOne_thenReturnFalse2() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsValue(COSInteger.ONE));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSName#A} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when COSObject(COSBase, COSObjectKey) with object is A and objectKey is COSObjectKey(long, int)")
  void testContainsValue_whenCOSObjectWithObjectIsAAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsValue(new COSObject(COSName.A, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSBoolean#FALSE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  void testContainsValue_whenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSFloat#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testContainsValue_whenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsValue(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSInteger#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testContainsValue_whenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey2() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsValue(new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link COSDictionary#containsValue(Object)}.
   * <ul>
   *   <li>When {@link COSInteger#OUT_OF_RANGE_MIN}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsValue(Object)}
   */
  @Test
  @DisplayName("Test containsValue(Object); when OUT_OF_RANGE_MIN; then return 'true'")
  void testContainsValue_whenOut_of_range_min_thenReturnTrue() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertTrue(cosStream.containsValue(COSInteger.OUT_OF_RANGE_MIN));
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyForValue(Object); given COSDictionary(); when 'Value'; then return 'null'")
  void testGetKeyForValue_givenCOSDictionary_whenValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getKeyForValue("Value"));
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyForValue(Object); given COSStream(); when ONE; then return 'null'")
  void testGetKeyForValue_givenCOSStream_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getKeyForValue(COSInteger.ONE));
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSInteger#OUT_OF_RANGE_MIN}.</li>
   *   <li>Then return {@link COSName#LENGTH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyForValue(Object); given COSStream(); when OUT_OF_RANGE_MIN; then return LENGTH")
  void testGetKeyForValue_givenCOSStream_whenOut_of_range_min_thenReturnLength() {
    // Arrange and Act
    COSName actualKeyForValue = (new COSStream()).getKeyForValue(COSInteger.OUT_OF_RANGE_MIN);

    // Assert
    assertSame(actualKeyForValue.LENGTH, actualKeyForValue);
  }

  /**
   * Test {@link COSDictionary#getKeyForValue(Object)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getKeyForValue(Object)}
   */
  @Test
  @DisplayName("Test getKeyForValue(Object); given COSStream(); when 'Value'; then return 'null'")
  void testGetKeyForValue_givenCOSStream_whenValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getKeyForValue("Value"));
  }

  /**
   * Test {@link COSDictionary#size()}.
   * <p>
   * Method under test: {@link COSDictionary#size()}
   */
  @Test
  @DisplayName("Test size()")
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new COSDictionary()).size());
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName, COSName)} with
   * {@code COSName}, {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getDictionaryObject(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName, COSName) with 'COSName', 'COSName'; given COSDictionary(); when A")
  void testGetDictionaryObjectWithCOSNameCOSName_givenCOSDictionary_whenA() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getDictionaryObject(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName, COSName)} with
   * {@code COSName}, {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getDictionaryObject(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName, COSName) with 'COSName', 'COSName'; given COSDictionary(); when 'null'")
  void testGetDictionaryObjectWithCOSNameCOSName_givenCOSDictionary_whenNull() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getDictionaryObject(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName, COSName)} with
   * {@code COSName}, {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getDictionaryObject(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName, COSName) with 'COSName', 'COSName'; given COSStream(); when A")
  void testGetDictionaryObjectWithCOSNameCOSName_givenCOSStream_whenA() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getDictionaryObject(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDictionaryObject(COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName) with 'COSName'; given COSDictionary()")
  void testGetDictionaryObjectWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getDictionaryObject(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDictionaryObject(COSName)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(COSName) with 'COSName'; given COSStream()")
  void testGetDictionaryObjectWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getDictionaryObject(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDictionaryObject(String)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(String) with 'String'; given COSDictionary()")
  void testGetDictionaryObjectWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getDictionaryObject("Key"));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDictionaryObject(String)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetDictionaryObjectWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary(new COSDictionary())).getDictionaryObject("Key"));
  }

  /**
   * Test {@link COSDictionary#getDictionaryObject(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDictionaryObject(String)}
   */
  @Test
  @DisplayName("Test getDictionaryObject(String) with 'String'; given COSStream()")
  void testGetDictionaryObjectWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getDictionaryObject("Key"));
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithCOSNameCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) value);

    // Assert
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithCOSNameCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem((COSName) null, (COSBase) value);

    // Assert
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when COSArray(); then COSDictionary() Values size is one")
  void testSetItemWithCOSNameCOSBase_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) new COSArray());

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when COSDictionary(); then COSDictionary() size is zero")
  void testSetItemWithCOSNameCOSBase_whenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSDictionary value = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) value);

    // Assert
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithCOSNameCOSBase_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} is {@link COSBoolean#FALSE} {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when FALSE; then COSDictionary() items 'null' is FALSE FALSE")
  void testSetItemWithCOSNameCOSBase_whenFalse_thenCOSDictionaryItemsNullIsFalseFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSBoolean value = COSBoolean.FALSE;

    // Act
    cosDictionary.setItem((COSName) null, value);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, cosDictionary.size());
    COSBoolean expectedGetResult = value.FALSE;
    assertSame(expectedGetResult, cosNameCosBaseMap.get(null));
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when FALSE; then COSDictionary() Values size is one")
  void testSetItemWithCOSNameCOSBase_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when 'null'; then COSDictionary() size is zero")
  void testSetItemWithCOSNameCOSBase_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem(COSName.A, (COSBase) null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSBase)} with {@code COSName},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSBase) with 'COSName', 'COSBase'; when 'null'; then COSDictionary() size is zero")
  void testSetItemWithCOSNameCOSBase_whenNull_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem((COSName) null, (COSBase) null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'")
  void testSetItemWithCOSNameCOSObjectable() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'")
  void testSetItemWithCOSNameCOSObjectable2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary cosDictionary2 = new COSDictionary();
    cosDictionary2.setKey(new COSObjectKey(1L, 1));
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given COSArray()")
  void testSetItemWithCOSNameCOSObjectable_givenCOSArray() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSArray());

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithCOSNameCOSObjectable_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given FALSE")
  void testSetItemWithCOSNameCOSObjectable_givenFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given 'null'; then COSDictionary() size is zero")
  void testSetItemWithCOSNameCOSObjectable_givenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(null);

    // Act
    cosDictionary.setItem(COSName.A, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; given 'null'; then COSDictionary() size is zero")
  void testSetItemWithCOSNameCOSObjectable_givenNull_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(null);

    // Act
    cosDictionary.setItem((COSName) null, value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(COSName, COSObjectable)} with
   * {@code COSName}, {@code COSObjectable}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSObject}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(COSName, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(COSName, COSObjectable) with 'COSName', 'COSObjectable'; then COSDictionary() items 'null' COSObject")
  void testSetItemWithCOSNameCOSObjectable_thenCOSDictionaryItemsNullCOSObject() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary cosDictionary2 = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary2.setKey(key);
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    cosDictionary.setItem((COSName) null, value);

    // Assert
    verify(value).getCOSObject();
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(cosDictionary2, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String},
   * {@code COSBase}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(String, COSBase) with 'String', 'COSBase'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithStringCOSBase_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.setItem("Key", (COSBase) value);

    // Assert
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(String, COSBase) with 'String', 'COSBase'; when COSArray(); then COSDictionary() Values size is one")
  void testSetItemWithStringCOSBase_whenCOSArray_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) new COSArray());

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(String, COSBase) with 'String', 'COSBase'; when COSDictionary(); then COSDictionary() size is zero")
  void testSetItemWithStringCOSBase_whenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSDictionary value = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) value);

    // Assert
    assertEquals(0, value.size());
    assertTrue(value.getValues().isEmpty());
    assertTrue(value.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(String, COSBase) with 'String', 'COSBase'; when COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithStringCOSBase_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(String, COSBase) with 'String', 'COSBase'; when FALSE; then COSDictionary() Values size is one")
  void testSetItemWithStringCOSBase_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", COSBoolean.FALSE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSBase)} with {@code String},
   * {@code COSBase}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSBase)}
   */
  @Test
  @DisplayName("Test setItem(String, COSBase) with 'String', 'COSBase'; when 'null'; then COSDictionary() size is zero")
  void testSetItemWithStringCOSBase_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setItem("Key", (COSBase) null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with
   * {@code String}, {@code COSObjectable}.
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'")
  void testSetItemWithStringCOSObjectable() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with
   * {@code String}, {@code COSObjectable}.
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'")
  void testSetItemWithStringCOSObjectable2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    COSDictionary cosDictionary2 = new COSDictionary();
    cosDictionary2.setKey(new COSObjectKey(1L, 1));
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with
   * {@code String}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given COSArray()")
  void testSetItemWithStringCOSObjectable_givenCOSArray() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSArray());

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with
   * {@code String}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetItemWithStringCOSObjectable_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with
   * {@code String}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given FALSE")
  void testSetItemWithStringCOSObjectable_givenFalse() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(COSBoolean.FALSE);

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setItem(String, COSObjectable)} with
   * {@code String}, {@code COSObjectable}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setItem(String, COSObjectable)}
   */
  @Test
  @DisplayName("Test setItem(String, COSObjectable) with 'String', 'COSObjectable'; given 'null'; then COSDictionary() size is zero")
  void testSetItemWithStringCOSObjectable_givenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectable value = mock(COSObjectable.class);
    when(value.getCOSObject()).thenReturn(null);

    // Act
    cosDictionary.setItem("Key", value);

    // Assert
    verify(value).getCOSObject();
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName("Test setName(COSName, String) with 'COSName', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetNameWithCOSNameString_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName(COSName.A, null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName("Test setName(COSName, String) with 'COSName', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetNameWithCOSNameString_givenCOSDictionary_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName((COSName) null, null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName("Test setName(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() items 'null' COSName")
  void testSetNameWithCOSNameString_when42_thenCOSDictionaryItemsNullCOSName() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName((COSName) null, "42");

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSName);
    assertEquals("42", ((COSName) getResult).getName());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(COSName, String)}
   */
  @Test
  @DisplayName("Test setName(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() Values size is one")
  void testSetNameWithCOSNameString_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName(COSName.A, "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setName(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String) with 'String', 'String'; when '42'; then COSDictionary() Values size is one")
  void testSetNameWithStringString_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName("Key", "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setName(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String) with 'String', 'String'; when 'null'; then COSDictionary() size is zero")
  void testSetNameWithStringString_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName("Key", null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setName(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String) with 'String', 'String'; when 'Value'; then COSDictionary() Values size is one")
  void testSetNameWithStringString_whenValue_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setName("Key", "Value");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(COSName, boolean)} with {@code COSName},
   * {@code boolean}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(COSName, boolean) with 'COSName', 'boolean'; then COSDictionary() Values size is one")
  void testSetBooleanWithCOSNameBoolean_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean(COSName.A, true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(COSName, boolean)} with {@code COSName},
   * {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(COSName, boolean) with 'COSName', 'boolean'; when 'false'; then COSDictionary() Values size is one")
  void testSetBooleanWithCOSNameBoolean_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean(COSName.A, false);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <p>
   * Method under test: {@link COSDictionary#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(String, boolean) with 'String', 'boolean'")
  void testSetBooleanWithStringBoolean() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());

    // Act
    cosDictionary.setBoolean("Key", true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(String, boolean) with 'String', 'boolean'; then COSDictionary() Values size is one")
  void testSetBooleanWithStringBoolean_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean("Key", true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test setBoolean(String, boolean) with 'String', 'boolean'; when 'false'; then COSDictionary() Values size is one")
  void testSetBooleanWithStringBoolean_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setBoolean("Key", false);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName},
   * {@code Calendar}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetDateWithCOSNameCalendar_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate(COSName.A, null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName},
   * {@code Calendar}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetDateWithCOSNameCalendar_givenCOSDictionary_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate((COSName) null, null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName},
   * {@code Calendar}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; then COSDictionary() items 'null' COSString")
  void testSetDateWithCOSNameCalendar_thenCOSDictionaryItemsNullCOSString() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate((COSName) null, new GregorianCalendar(1, 1, 1));

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSString);
    assertNull(getResult.getKey());
    assertEquals(23, ((COSString) getResult).getBytes().length);
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
  }

  /**
   * Test {@link COSDictionary#setDate(COSName, Calendar)} with {@code COSName},
   * {@code Calendar}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(COSName, Calendar) with 'COSName', 'Calendar'; then COSDictionary() Values size is one")
  void testSetDateWithCOSNameCalendar_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate(COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <p>
   * Method under test: {@link COSDictionary#setDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(String, Calendar) with 'String', 'Calendar'")
  void testSetDateWithStringCalendar() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary(new COSDictionary());

    // Act
    cosDictionary.setDate("Key", new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(String, Calendar) with 'String', 'Calendar'; then COSDictionary() Values size is one")
  void testSetDateWithStringCalendar_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate("Key", new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <ul>
   *   <li>When {@code name}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(String, Calendar) with 'String', 'Calendar'; when 'name'; then COSDictionary() Values size is one")
  void testSetDateWithStringCalendar_whenName_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate("name", new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDate(String, Calendar) with 'String', 'Calendar'; when 'null'; then COSDictionary() size is zero")
  void testSetDateWithStringCalendar_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setDate("Key", null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setEmbeddedDate(COSName, COSName, Calendar); given COSDictionary(); then COSDictionary() Values size is one")
  void testSetEmbeddedDate_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedDate(COSName.A, COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setEmbeddedDate(COSName, COSName, Calendar); given COSDictionary(); when 'null'; then COSDictionary() size is zero")
  void testSetEmbeddedDate_givenCOSDictionary_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedDate(COSName.A, COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setEmbeddedDate(COSName, COSName, Calendar); given COSStream(); then COSStream() Values size is two")
  void testSetEmbeddedDate_givenCOSStream_thenCOSStreamValuesSizeIsTwo() {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.setEmbeddedDate(COSName.A, COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName("Test setEmbeddedDate(COSName, COSName, Calendar); when 'null'; then COSDictionary() items 'null' COSDictionary")
  void testSetEmbeddedDate_whenNull_thenCOSDictionaryItemsNullCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedDate(null, COSName.A, new GregorianCalendar(1, 1, 1));

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).items.size());
    assertEquals(1, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName("Test setString(COSName, String) with 'COSName', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetStringWithCOSNameString_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString(COSName.A, null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName("Test setString(COSName, String) with 'COSName', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetStringWithCOSNameString_givenCOSDictionary_thenCOSDictionarySizeIsZero2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString((COSName) null, null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName("Test setString(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() items 'null' COSString")
  void testSetStringWithCOSNameString_when42_thenCOSDictionaryItemsNullCOSString() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString((COSName) null, "42");

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSDictionary#setString(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(COSName, String)}
   */
  @Test
  @DisplayName("Test setString(COSName, String) with 'COSName', 'String'; when '42'; then COSDictionary() Values size is one")
  void testSetStringWithCOSNameString_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString(COSName.A, "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setString(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String) with 'String', 'String'; given COSDictionary(); then COSDictionary() size is zero")
  void testSetStringWithStringString_givenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString("Key", null);

    // Assert
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setString(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String) with 'String', 'String'; then COSDictionary() Values size is one")
  void testSetStringWithStringString_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setString("Key", "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName("Test setEmbeddedString(COSName, COSName, String); given COSDictionary(); when '42'; then COSDictionary() Values size is one")
  void testSetEmbeddedString_givenCOSDictionary_when42_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedString(COSName.A, COSName.A, "42");

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName("Test setEmbeddedString(COSName, COSName, String); given COSDictionary(); when 'null'; then COSDictionary() size is zero")
  void testSetEmbeddedString_givenCOSDictionary_whenNull_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedString(COSName.A, COSName.A, null);

    // Assert that nothing has changed
    assertEquals(0, cosDictionary.size());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(cosDictionary.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSStream#COSStream()} Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName("Test setEmbeddedString(COSName, COSName, String); given COSStream(); when '42'; then COSStream() Values size is two")
  void testSetEmbeddedString_givenCOSStream_when42_thenCOSStreamValuesSizeIsTwo() {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.setEmbeddedString(COSName.A, COSName.A, "42");

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName("Test setEmbeddedString(COSName, COSName, String); when 'null'; then COSDictionary() items 'null' COSDictionary")
  void testSetEmbeddedString_whenNull_thenCOSDictionaryItemsNullCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedString(null, COSName.A, "42");

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).items.size());
    assertEquals(1, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#setInt(COSName, int)} with {@code COSName},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setInt(COSName, int)}
   */
  @Test
  @DisplayName("Test setInt(COSName, int) with 'COSName', 'int'; given COSDictionary(); then COSDictionary() Values size is one")
  void testSetIntWithCOSNameInt_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt(COSName.A, 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(COSName, int)} with {@code COSName},
   * {@code int}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setInt(COSName, int)}
   */
  @Test
  @DisplayName("Test setInt(COSName, int) with 'COSName', 'int'; when MIN_VALUE; then COSDictionary() Values size is one")
  void testSetIntWithCOSNameInt_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt(COSName.A, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(COSName, int)} with {@code COSName},
   * {@code int}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setInt(COSName, int)}
   */
  @Test
  @DisplayName("Test setInt(COSName, int) with 'COSName', 'int'; when 'null'; then COSDictionary() items 'null' COSInteger")
  void testSetIntWithCOSNameInt_whenNull_thenCOSDictionaryItemsNullCOSInteger() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt((COSName) null, 42);

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSDictionary#setInt(String, int)} with {@code String},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setInt(String, int)}
   */
  @Test
  @DisplayName("Test setInt(String, int) with 'String', 'int'; given COSDictionary(); then COSDictionary() Values size is one")
  void testSetIntWithStringInt_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt("Key", 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setInt(String, int)} with {@code String},
   * {@code int}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setInt(String, int)}
   */
  @Test
  @DisplayName("Test setInt(String, int) with 'String', 'int'; when MIN_VALUE; then COSDictionary() Values size is one")
  void testSetIntWithStringInt_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setInt("Key", Integer.MIN_VALUE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(COSName, long)} with {@code COSName},
   * {@code long}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(COSName, long)}
   */
  @Test
  @DisplayName("Test setLong(COSName, long) with 'COSName', 'long'; when forty-two; then COSDictionary() Values size is one")
  void testSetLongWithCOSNameLong_whenFortyTwo_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong(COSName.A, 42L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(COSName, long)} with {@code COSName},
   * {@code long}.
   * <ul>
   *   <li>When minus one hundred one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(COSName, long)}
   */
  @Test
  @DisplayName("Test setLong(COSName, long) with 'COSName', 'long'; when minus one hundred one")
  void testSetLongWithCOSNameLong_whenMinusOneHundredOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong(COSName.A, -101L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(COSName, long)} with {@code COSName},
   * {@code long}.
   * <ul>
   *   <li>When two hundred fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(COSName, long)}
   */
  @Test
  @DisplayName("Test setLong(COSName, long) with 'COSName', 'long'; when two hundred fifty-seven")
  void testSetLongWithCOSNameLong_whenTwoHundredFiftySeven() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong(COSName.A, 257L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String},
   * {@code long}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long) with 'String', 'long'; when forty-two; then COSDictionary() Values size is one")
  void testSetLongWithStringLong_whenFortyTwo_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("Key", 42L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String},
   * {@code long}.
   * <ul>
   *   <li>When minus one hundred one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long) with 'String', 'long'; when minus one hundred one")
  void testSetLongWithStringLong_whenMinusOneHundredOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("Key", -101L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setLong(String, long)} with {@code String},
   * {@code long}.
   * <ul>
   *   <li>When two hundred fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setLong(String, long)}
   */
  @Test
  @DisplayName("Test setLong(String, long) with 'String', 'long'; when two hundred fifty-seven")
  void testSetLongWithStringLong_whenTwoHundredFiftySeven() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setLong("Key", 257L);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test setEmbeddedInt(COSName, COSName, int); given COSDictionary(); then COSDictionary() Values size is one")
  void testSetEmbeddedInt_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedInt(COSName.A, COSName.A, 42);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When forty-two.</li>
   *   <li>Then {@link COSStream#COSStream()} Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test setEmbeddedInt(COSName, COSName, int); given COSStream(); when forty-two; then COSStream() Values size is two")
  void testSetEmbeddedInt_givenCOSStream_whenFortyTwo_thenCOSStreamValuesSizeIsTwo() {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.setEmbeddedInt(COSName.A, COSName.A, 42);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test setEmbeddedInt(COSName, COSName, int); when MIN_VALUE; then COSDictionary() Values size is one")
  void testSetEmbeddedInt_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedInt(COSName.A, COSName.A, Integer.MIN_VALUE);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#setEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test setEmbeddedInt(COSName, COSName, int); when 'null'; then COSDictionary() items 'null' COSDictionary")
  void testSetEmbeddedInt_whenNull_thenCOSDictionaryItemsNullCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setEmbeddedInt(null, COSName.A, 42);

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSDictionary);
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).items.size());
    assertEquals(1, ((COSDictionary) getResult).size());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#setFloat(COSName, float)} with {@code COSName},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFloat(COSName, float)}
   */
  @Test
  @DisplayName("Test setFloat(COSName, float) with 'COSName', 'float'; given COSDictionary(); then COSDictionary() Values size is one")
  void testSetFloatWithCOSNameFloat_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFloat(COSName.A, 10.0f);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFloat(COSName, float)} with {@code COSName},
   * {@code float}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFloat(COSName, float)}
   */
  @Test
  @DisplayName("Test setFloat(COSName, float) with 'COSName', 'float'; when 'null'; then COSDictionary() items 'null' COSFloat")
  void testSetFloatWithCOSNameFloat_whenNull_thenCOSDictionaryItemsNullCOSFloat() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFloat((COSName) null, 10.0f);

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link COSDictionary#setFloat(String, float)} with {@code String},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFloat(String, float)}
   */
  @Test
  @DisplayName("Test setFloat(String, float) with 'String', 'float'; given COSDictionary(); then COSDictionary() Values size is one")
  void testSetFloatWithStringFloat_givenCOSDictionary_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFloat("Key", 10.0f);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(COSName, int, boolean); given COSDictionary(); when A; then COSDictionary() Values size is one")
  void testSetFlag_givenCOSDictionary_whenA_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(COSName.A, 1, true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(COSName, int, boolean); given COSDictionary(); when 'false'; then COSDictionary() Values size is one")
  void testSetFlag_givenCOSDictionary_whenFalse_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(COSName.A, 1, false);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(COSName, int, boolean); given COSDictionary(); when MIN_VALUE; then COSDictionary() Values size is one")
  void testSetFlag_givenCOSDictionary_whenMin_value_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(COSName.A, Integer.MIN_VALUE, true);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} {@link COSDictionary#items}
   * {@code null} {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(COSName, int, boolean); given COSDictionary(); when 'null'; then COSDictionary() items 'null' COSInteger")
  void testSetFlag_givenCOSDictionary_whenNull_thenCOSDictionaryItemsNullCOSInteger() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    cosDictionary.setFlag(null, 1, true);

    // Assert
    Map<COSName, COSBase> cosNameCosBaseMap = cosDictionary.items;
    assertEquals(1, cosNameCosBaseMap.size());
    COSBase getResult = cosNameCosBaseMap.get(null);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSDictionary#setFlag(COSName, int, boolean)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then {@link COSStream#COSStream()} Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#setFlag(COSName, int, boolean)}
   */
  @Test
  @DisplayName("Test setFlag(COSName, int, boolean); given COSStream(); when A; then COSStream() Values size is two")
  void testSetFlag_givenCOSStream_whenA_thenCOSStreamValuesSizeIsTwo() {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.setFlag(COSName.A, 1, true);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName, COSName)} with {@code key},
   * {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSName(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName, COSName) with 'key', 'defaultValue'; given COSDictionary()")
  void testGetCOSNameWithKeyDefaultValue_givenCOSDictionary() {
    // Arrange and Act
    COSName actualCOSName = (new COSDictionary()).getCOSName(COSName.A, COSName.A);

    // Assert
    assertSame(actualCOSName.A, actualCOSName);
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName, COSName)} with {@code key},
   * {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSName(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName, COSName) with 'key', 'defaultValue'; given COSStream()")
  void testGetCOSNameWithKeyDefaultValue_givenCOSStream() {
    // Arrange and Act
    COSName actualCOSName = (new COSStream()).getCOSName(COSName.A, COSName.A);

    // Assert
    assertSame(actualCOSName.A, actualCOSName);
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName)} with {@code key}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSName(COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName) with 'key'; given COSDictionary()")
  void testGetCOSNameWithKey_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSName(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSName(COSName)} with {@code key}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSName(COSName)}
   */
  @Test
  @DisplayName("Test getCOSName(COSName) with 'key'; given COSStream()")
  void testGetCOSNameWithKey_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getCOSName(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName, String)} with
   * {@code COSName}, {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(COSName, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName, String) with 'COSName', 'String'; given COSDictionary()")
  void testGetNameAsStringWithCOSNameString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getNameAsString(COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName, String)} with
   * {@code COSName}, {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(COSName, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName, String) with 'COSName', 'String'; given COSStream()")
  void testGetNameAsStringWithCOSNameString_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSStream()).getNameAsString(COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(COSName)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName) with 'COSName'; given COSDictionary()")
  void testGetNameAsStringWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getNameAsString(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(COSName)}
   */
  @Test
  @DisplayName("Test getNameAsString(COSName) with 'COSName'; given COSStream()")
  void testGetNameAsStringWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getNameAsString(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String, String)} with
   * {@code String}, {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(String, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String, String) with 'String', 'String'; given COSDictionary(); when 'COSArray{'; then return '42'")
  void testGetNameAsStringWithStringString_givenCOSDictionary_whenCOSArray_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getNameAsString("COSArray{", "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String, String)} with
   * {@code String}, {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(String, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String, String) with 'String', 'String'; given COSDictionary(); when 'Key'; then return '42'")
  void testGetNameAsStringWithStringString_givenCOSDictionary_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getNameAsString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String, String)} with
   * {@code String}, {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(String, String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String, String) with 'String', 'String'; given COSStream(); when 'Key'; then return '42'")
  void testGetNameAsStringWithStringString_givenCOSStream_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSStream()).getNameAsString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String) with 'String'; given COSDictionary()")
  void testGetNameAsStringWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getNameAsString("Key"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetNameAsStringWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary(new COSDictionary())).getNameAsString("Key"));
  }

  /**
   * Test {@link COSDictionary#getNameAsString(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getNameAsString(String)}
   */
  @Test
  @DisplayName("Test getNameAsString(String) with 'String'; given COSStream()")
  void testGetNameAsStringWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getNameAsString("Key"));
  }

  /**
   * Test {@link COSDictionary#getString(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(COSName, String)}
   */
  @Test
  @DisplayName("Test getString(COSName, String) with 'COSName', 'String'; given COSDictionary()")
  void testGetStringWithCOSNameString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getString(COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getString(COSName, String)} with {@code COSName},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(COSName, String)}
   */
  @Test
  @DisplayName("Test getString(COSName, String) with 'COSName', 'String'; given COSStream()")
  void testGetStringWithCOSNameString_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSStream()).getString(COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getString(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(COSName)}
   */
  @Test
  @DisplayName("Test getString(COSName) with 'COSName'; given COSDictionary()")
  void testGetStringWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getString(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getString(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(COSName)}
   */
  @Test
  @DisplayName("Test getString(COSName) with 'COSName'; given COSStream()")
  void testGetStringWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getString(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getString(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String, String)}
   */
  @Test
  @DisplayName("Test getString(String, String) with 'String', 'String'; given COSDictionary(); when 'COSArray{'; then return '42'")
  void testGetStringWithStringString_givenCOSDictionary_whenCOSArray_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getString("COSArray{", "42"));
  }

  /**
   * Test {@link COSDictionary#getString(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String, String)}
   */
  @Test
  @DisplayName("Test getString(String, String) with 'String', 'String'; given COSDictionary(); when 'Key'; then return '42'")
  void testGetStringWithStringString_givenCOSDictionary_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getString(String, String)} with {@code String},
   * {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String, String)}
   */
  @Test
  @DisplayName("Test getString(String, String) with 'String', 'String'; given COSStream(); when 'Key'; then return '42'")
  void testGetStringWithStringString_givenCOSStream_whenKey_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSStream()).getString("Key", "42"));
  }

  /**
   * Test {@link COSDictionary#getString(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'String'; given COSDictionary()")
  void testGetStringWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getString("Key"));
  }

  /**
   * Test {@link COSDictionary#getString(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetStringWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary(new COSDictionary())).getString("Key"));
  }

  /**
   * Test {@link COSDictionary#getString(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String) with 'String'; given COSStream()")
  void testGetStringWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getString("Key"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName, String)} with
   * {@code embedded}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName("Test getEmbeddedString(COSName, COSName, String) with 'embedded', 'key', 'defaultValue'; given COSDictionary()")
  void testGetEmbeddedStringWithEmbeddedKeyDefaultValue_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSDictionary()).getEmbeddedString(COSName.A, COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName, String)} with
   * {@code embedded}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getEmbeddedString(COSName, COSName, String)}
   */
  @Test
  @DisplayName("Test getEmbeddedString(COSName, COSName, String) with 'embedded', 'key', 'defaultValue'; given COSStream()")
  void testGetEmbeddedStringWithEmbeddedKeyDefaultValue_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals("42", (new COSStream()).getEmbeddedString(COSName.A, COSName.A, "42"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName)} with
   * {@code embedded}, {@code key}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getEmbeddedString(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedString(COSName, COSName) with 'embedded', 'key'; given COSDictionary()")
  void testGetEmbeddedStringWithEmbeddedKey_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getEmbeddedString(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedString(COSName, COSName)} with
   * {@code embedded}, {@code key}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getEmbeddedString(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedString(COSName, COSName) with 'embedded', 'key'; given COSStream()")
  void testGetEmbeddedStringWithEmbeddedKey_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getEmbeddedString(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDate(COSName, Calendar)} with {@code COSName},
   * {@code Calendar}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(COSName, Calendar) with 'COSName', 'Calendar'; given COSDictionary()")
  void testGetDateWithCOSNameCalendar_givenCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosDictionary.getDate(COSName.A, defaultValue));
  }

  /**
   * Test {@link COSDictionary#getDate(COSName, Calendar)} with {@code COSName},
   * {@code Calendar}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(COSName, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(COSName, Calendar) with 'COSName', 'Calendar'; given COSStream()")
  void testGetDateWithCOSNameCalendar_givenCOSStream() {
    // Arrange
    COSStream cosStream = new COSStream();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosStream.getDate(COSName.A, defaultValue));
  }

  /**
   * Test {@link COSDictionary#getDate(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(COSName)}
   */
  @Test
  @DisplayName("Test getDate(COSName) with 'COSName'; given COSDictionary()")
  void testGetDateWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getDate(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDate(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(COSName)}
   */
  @Test
  @DisplayName("Test getDate(COSName) with 'COSName'; given COSStream()")
  void testGetDateWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getDate(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(String, Calendar) with 'String', 'Calendar'; given COSStream(); when 'Key'")
  void testGetDateWithStringCalendar_givenCOSStream_whenKey() {
    // Arrange
    COSStream cosStream = new COSStream();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosStream.getDate("Key", defaultValue));
  }

  /**
   * Test {@link COSDictionary#getDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <ul>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(String, Calendar) with 'String', 'Calendar'; when 'COSArray{'")
  void testGetDateWithStringCalendar_whenCOSArray() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosDictionary.getDate("COSArray{", defaultValue));
  }

  /**
   * Test {@link COSDictionary#getDate(String, Calendar)} with {@code String},
   * {@code Calendar}.
   * <ul>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String, Calendar)}
   */
  @Test
  @DisplayName("Test getDate(String, Calendar) with 'String', 'Calendar'; when 'Key'")
  void testGetDateWithStringCalendar_whenKey() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosDictionary.getDate("Key", defaultValue));
  }

  /**
   * Test {@link COSDictionary#getDate(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String)}
   */
  @Test
  @DisplayName("Test getDate(String) with 'String'; given COSDictionary()")
  void testGetDateWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getDate("Key"));
  }

  /**
   * Test {@link COSDictionary#getDate(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String)}
   */
  @Test
  @DisplayName("Test getDate(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetDateWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary(new COSDictionary())).getDate("Key"));
  }

  /**
   * Test {@link COSDictionary#getDate(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getDate(String)}
   */
  @Test
  @DisplayName("Test getDate(String) with 'String'; given COSStream()")
  void testGetDateWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getDate("Key"));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)} with
   * {@code embedded}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName("Test getEmbeddedDate(COSName, COSName, Calendar) with 'embedded', 'key', 'defaultValue'; given COSDictionary()")
  void testGetEmbeddedDateWithEmbeddedKeyDefaultValue_givenCOSDictionary() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosDictionary.getEmbeddedDate(COSName.A, COSName.A, defaultValue));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)} with
   * {@code embedded}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getEmbeddedDate(COSName, COSName, Calendar)}
   */
  @Test
  @DisplayName("Test getEmbeddedDate(COSName, COSName, Calendar) with 'embedded', 'key', 'defaultValue'; given COSStream()")
  void testGetEmbeddedDateWithEmbeddedKeyDefaultValue_givenCOSStream() {
    // Arrange
    COSStream cosStream = new COSStream();
    GregorianCalendar defaultValue = new GregorianCalendar(1, 1, 1);

    // Act and Assert
    assertSame(defaultValue, cosStream.getEmbeddedDate(COSName.A, COSName.A, defaultValue));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName)} with
   * {@code embedded}, {@code key}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getEmbeddedDate(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedDate(COSName, COSName) with 'embedded', 'key'; given COSDictionary()")
  void testGetEmbeddedDateWithEmbeddedKey_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getEmbeddedDate(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedDate(COSName, COSName)} with
   * {@code embedded}, {@code key}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getEmbeddedDate(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedDate(COSName, COSName) with 'embedded', 'key'; given COSStream()")
  void testGetEmbeddedDateWithEmbeddedKey_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getEmbeddedDate(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSObject(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSObject(COSName)}
   */
  @Test
  @DisplayName("Test getCOSObject(COSName) with 'COSName'; given COSDictionary()")
  void testGetCOSObjectWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSObject(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSObject(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSObject(COSName)}
   */
  @Test
  @DisplayName("Test getCOSObject(COSName) with 'COSName'; given COSStream()")
  void testGetCOSObjectWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getCOSObject(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName, COSName)} with
   * {@code firstKey}, {@code secondKey}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName, COSName) with 'firstKey', 'secondKey'; given COSDictionary(); when A")
  void testGetCOSDictionaryWithFirstKeySecondKey_givenCOSDictionary_whenA() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSDictionary(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName, COSName)} with
   * {@code firstKey}, {@code secondKey}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName, COSName) with 'firstKey', 'secondKey'; given COSDictionary(); when 'null'")
  void testGetCOSDictionaryWithFirstKeySecondKey_givenCOSDictionary_whenNull() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSDictionary(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName, COSName)} with
   * {@code firstKey}, {@code secondKey}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSDictionary(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName, COSName) with 'firstKey', 'secondKey'; given COSStream(); when A")
  void testGetCOSDictionaryWithFirstKeySecondKey_givenCOSStream_whenA() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getCOSDictionary(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName)} with {@code key}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName) with 'key'; given COSDictionary()")
  void testGetCOSDictionaryWithKey_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSDictionary(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSDictionary(COSName)} with {@code key}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSDictionary(COSName)}
   */
  @Test
  @DisplayName("Test getCOSDictionary(COSName) with 'key'; given COSStream()")
  void testGetCOSDictionaryWithKey_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getCOSDictionary(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSStream(COSName)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSStream(COSName)}
   */
  @Test
  @DisplayName("Test getCOSStream(COSName); given COSDictionary()")
  void testGetCOSStream_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSStream(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSStream(COSName)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSStream(COSName)}
   */
  @Test
  @DisplayName("Test getCOSStream(COSName); given COSStream()")
  void testGetCOSStream_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getCOSStream(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSArray(COSName)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSArray(COSName)}
   */
  @Test
  @DisplayName("Test getCOSArray(COSName); given COSDictionary()")
  void testGetCOSArray_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getCOSArray(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getCOSArray(COSName)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getCOSArray(COSName)}
   */
  @Test
  @DisplayName("Test getCOSArray(COSName); given COSStream()")
  void testGetCOSArray_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getCOSArray(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, boolean)} with {@code COSName},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, boolean) with 'COSName', 'boolean'; given COSDictionary(); when 'false'; then return 'false'")
  void testGetBooleanWithCOSNameBoolean_givenCOSDictionary_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).getBoolean(COSName.A, false));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, boolean)} with {@code COSName},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, boolean) with 'COSName', 'boolean'; given COSDictionary(); when 'true'; then return 'true'")
  void testGetBooleanWithCOSNameBoolean_givenCOSDictionary_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).getBoolean(COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, boolean)} with {@code COSName},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, boolean) with 'COSName', 'boolean'; given COSStream(); when 'true'; then return 'true'")
  void testGetBooleanWithCOSNameBoolean_givenCOSStream_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSStream()).getBoolean(COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with
   * {@code COSName}, {@code COSName}, {@code boolean}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; given COSDictionary(); then return 'true'")
  void testGetBooleanWithCOSNameCOSNameBoolean_givenCOSDictionary_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).getBoolean(COSName.A, COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with
   * {@code COSName}, {@code COSName}, {@code boolean}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; given COSStream(); when 'true'; then return 'true'")
  void testGetBooleanWithCOSNameCOSNameBoolean_givenCOSStream_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSStream()).getBoolean(COSName.A, COSName.A, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with
   * {@code COSName}, {@code COSName}, {@code boolean}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; when 'false'; then return 'false'")
  void testGetBooleanWithCOSNameCOSNameBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).getBoolean(COSName.A, COSName.A, false));
  }

  /**
   * Test {@link COSDictionary#getBoolean(COSName, COSName, boolean)} with
   * {@code COSName}, {@code COSName}, {@code boolean}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getBoolean(COSName, COSName, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(COSName, COSName, boolean) with 'COSName', 'COSName', 'boolean'; when 'null'; then return 'true'")
  void testGetBooleanWithCOSNameCOSNameBoolean_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).getBoolean(COSName.A, null, true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(String, boolean) with 'String', 'boolean'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetBooleanWithStringBoolean_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary(new COSDictionary())).getBoolean("Key", true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(String, boolean) with 'String', 'boolean'; given COSDictionary(); when 'false'; then return 'false'")
  void testGetBooleanWithStringBoolean_givenCOSDictionary_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).getBoolean("Key", false));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(String, boolean) with 'String', 'boolean'; given COSDictionary(); when 'Key'; then return 'true'")
  void testGetBooleanWithStringBoolean_givenCOSDictionary_whenKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).getBoolean("Key", true));
  }

  /**
   * Test {@link COSDictionary#getBoolean(String, boolean)} with {@code String},
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getBoolean(String, boolean)}
   */
  @Test
  @DisplayName("Test getBoolean(String, boolean) with 'String', 'boolean'; given COSStream(); when 'Key'; then return 'true'")
  void testGetBooleanWithStringBoolean_givenCOSStream_whenKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSStream()).getBoolean("Key", true));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)} with
   * {@code embeddedDictionary}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getEmbeddedInt(COSName, COSName, int) with 'embeddedDictionary', 'key', 'defaultValue'; given COSDictionary()")
  void testGetEmbeddedIntWithEmbeddedDictionaryKeyDefaultValue_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSDictionary()).getEmbeddedInt(COSName.A, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)} with
   * {@code embeddedDictionary}, {@code key}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSDictionary#getEmbeddedInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getEmbeddedInt(COSName, COSName, int) with 'embeddedDictionary', 'key', 'defaultValue'; given COSStream()")
  void testGetEmbeddedIntWithEmbeddedDictionaryKeyDefaultValue_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSStream()).getEmbeddedInt(COSName.A, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName)} with
   * {@code embeddedDictionary}, {@code key}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getEmbeddedInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedInt(COSName, COSName) with 'embeddedDictionary', 'key'; given COSDictionary()")
  void testGetEmbeddedIntWithEmbeddedDictionaryKey_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSDictionary()).getEmbeddedInt(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getEmbeddedInt(COSName, COSName)} with
   * {@code embeddedDictionary}, {@code key}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getEmbeddedInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getEmbeddedInt(COSName, COSName) with 'embeddedDictionary', 'key'; given COSStream()")
  void testGetEmbeddedIntWithEmbeddedDictionaryKey_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSStream()).getEmbeddedInt(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName, int)} with
   * {@code COSName}, {@code COSName}, {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName, int) with 'COSName', 'COSName', 'int'; given COSDictionary(); when A")
  void testGetIntWithCOSNameCOSNameInt_givenCOSDictionary_whenA() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSDictionary()).getInt(COSName.A, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName, int)} with
   * {@code COSName}, {@code COSName}, {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName, int) with 'COSName', 'COSName', 'int'; given COSDictionary(); when 'null'")
  void testGetIntWithCOSNameCOSNameInt_givenCOSDictionary_whenNull() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSDictionary()).getInt(COSName.A, null, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName, int)} with
   * {@code COSName}, {@code COSName}, {@code int}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName, int) with 'COSName', 'COSName', 'int'; given COSStream(); when A")
  void testGetIntWithCOSNameCOSNameInt_givenCOSStream_whenA() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSStream()).getInt(COSName.A, COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName)} with {@code COSName},
   * {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName) with 'COSName', 'COSName'; given COSDictionary(); when A")
  void testGetIntWithCOSNameCOSName_givenCOSDictionary_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSDictionary()).getInt(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName)} with {@code COSName},
   * {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName) with 'COSName', 'COSName'; given COSDictionary(); when 'null'")
  void testGetIntWithCOSNameCOSName_givenCOSDictionary_whenNull() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSDictionary()).getInt(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, COSName)} with {@code COSName},
   * {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName, COSName) with 'COSName', 'COSName'; given COSStream(); when A")
  void testGetIntWithCOSNameCOSName_givenCOSStream_whenA() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSStream()).getInt(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, int)} with {@code COSName},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, int) with 'COSName', 'int'; given COSDictionary()")
  void testGetIntWithCOSNameInt_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSDictionary()).getInt(COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName, int)} with {@code COSName},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName, int)}
   */
  @Test
  @DisplayName("Test getInt(COSName, int) with 'COSName', 'int'; given COSStream()")
  void testGetIntWithCOSNameInt_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSStream()).getInt(COSName.A, 42));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName) with 'COSName'; given COSDictionary()")
  void testGetIntWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSDictionary()).getInt(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(COSName)}
   */
  @Test
  @DisplayName("Test getInt(COSName) with 'COSName'; given COSStream()")
  void testGetIntWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSStream()).getInt(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getInt(String, int)} with {@code String},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code COSArray{}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'String', 'int'; given COSDictionary(); when 'COSArray{'; then return forty-two")
  void testGetIntWithStringInt_givenCOSDictionary_whenCOSArray_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSDictionary()).getInt("COSArray{", 42));
  }

  /**
   * Test {@link COSDictionary#getInt(String, int)} with {@code String},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'String', 'int'; given COSDictionary(); when 'Key'; then return forty-two")
  void testGetIntWithStringInt_givenCOSDictionary_whenKey_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSDictionary()).getInt("Key", 42));
  }

  /**
   * Test {@link COSDictionary#getInt(String, int)} with {@code String},
   * {@code int}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String, int)}
   */
  @Test
  @DisplayName("Test getInt(String, int) with 'String', 'int'; given COSStream(); when 'Key'; then return forty-two")
  void testGetIntWithStringInt_givenCOSStream_whenKey_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, (new COSStream()).getInt("Key", 42));
  }

  /**
   * Test {@link COSDictionary#getInt(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetIntWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSDictionary(new COSDictionary())).getInt("Key"));
  }

  /**
   * Test {@link COSDictionary#getInt(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'String'; given COSDictionary(); when 'Key'; then return minus one")
  void testGetIntWithString_givenCOSDictionary_whenKey_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSDictionary()).getInt("Key"));
  }

  /**
   * Test {@link COSDictionary#getInt(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getInt(String)}
   */
  @Test
  @DisplayName("Test getInt(String) with 'String'; given COSStream(); when 'Key'; then return minus one")
  void testGetIntWithString_givenCOSStream_whenKey_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSStream()).getInt("Key"));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName, long)} with {@code COSName},
   * {@code long}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(COSName, long)}
   */
  @Test
  @DisplayName("Test getLong(COSName, long) with 'COSName', 'long'; given COSDictionary()")
  void testGetLongWithCOSNameLong_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(42L, (new COSDictionary()).getLong(COSName.A, 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName, long)} with {@code COSName},
   * {@code long}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(COSName, long)}
   */
  @Test
  @DisplayName("Test getLong(COSName, long) with 'COSName', 'long'; given COSStream()")
  void testGetLongWithCOSNameLong_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(42L, (new COSStream()).getLong(COSName.A, 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(COSName)}
   */
  @Test
  @DisplayName("Test getLong(COSName) with 'COSName'; given COSDictionary()")
  void testGetLongWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new COSDictionary()).getLong(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getLong(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(COSName)}
   */
  @Test
  @DisplayName("Test getLong(COSName) with 'COSName'; given COSStream()")
  void testGetLongWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new COSStream()).getLong(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getLong(String, long)} with {@code String},
   * {@code long}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'String', 'long'; given COSDictionary(); when 'COSArray{'")
  void testGetLongWithStringLong_givenCOSDictionary_whenCOSArray() {
    // Arrange, Act and Assert
    assertEquals(42L, (new COSDictionary()).getLong("COSArray{", 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(String, long)} with {@code String},
   * {@code long}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'String', 'long'; given COSDictionary(); when 'Key'")
  void testGetLongWithStringLong_givenCOSDictionary_whenKey() {
    // Arrange, Act and Assert
    assertEquals(42L, (new COSDictionary()).getLong("Key", 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(String, long)} with {@code String},
   * {@code long}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(String, long)}
   */
  @Test
  @DisplayName("Test getLong(String, long) with 'String', 'long'; given COSStream(); when 'Key'")
  void testGetLongWithStringLong_givenCOSStream_whenKey() {
    // Arrange, Act and Assert
    assertEquals(42L, (new COSStream()).getLong("Key", 42L));
  }

  /**
   * Test {@link COSDictionary#getLong(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'String'; given COSDictionary()")
  void testGetLongWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new COSDictionary()).getLong("Key"));
  }

  /**
   * Test {@link COSDictionary#getLong(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetLongWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new COSDictionary(new COSDictionary())).getLong("Key"));
  }

  /**
   * Test {@link COSDictionary#getLong(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getLong(String)}
   */
  @Test
  @DisplayName("Test getLong(String) with 'String'; given COSStream()")
  void testGetLongWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new COSStream()).getLong("Key"));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName, float)} with {@code COSName},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(COSName, float)}
   */
  @Test
  @DisplayName("Test getFloat(COSName, float) with 'COSName', 'float'; given COSDictionary()")
  void testGetFloatWithCOSNameFloat_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new COSDictionary()).getFloat(COSName.A, 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName, float)} with {@code COSName},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(COSName, float)}
   */
  @Test
  @DisplayName("Test getFloat(COSName, float) with 'COSName', 'float'; given COSStream()")
  void testGetFloatWithCOSNameFloat_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new COSStream()).getFloat(COSName.A, 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(COSName)}
   */
  @Test
  @DisplayName("Test getFloat(COSName) with 'COSName'; given COSDictionary()")
  void testGetFloatWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new COSDictionary()).getFloat(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getFloat(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(COSName)}
   */
  @Test
  @DisplayName("Test getFloat(COSName) with 'COSName'; given COSStream()")
  void testGetFloatWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new COSStream()).getFloat(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getFloat(String, float)} with {@code String},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'String', 'float'; given COSDictionary(); when 'COSArray{'")
  void testGetFloatWithStringFloat_givenCOSDictionary_whenCOSArray() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new COSDictionary()).getFloat("COSArray{", 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(String, float)} with {@code String},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'String', 'float'; given COSDictionary(); when 'Key'")
  void testGetFloatWithStringFloat_givenCOSDictionary_whenKey() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new COSDictionary()).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(String, float)} with {@code String},
   * {@code float}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String, float)}
   */
  @Test
  @DisplayName("Test getFloat(String, float) with 'String', 'float'; given COSStream(); when 'Key'")
  void testGetFloatWithStringFloat_givenCOSStream_whenKey() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new COSStream()).getFloat("Key", 10.0f));
  }

  /**
   * Test {@link COSDictionary#getFloat(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'String'; given COSDictionary()")
  void testGetFloatWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new COSDictionary()).getFloat("Key"));
  }

  /**
   * Test {@link COSDictionary#getFloat(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetFloatWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new COSDictionary(new COSDictionary())).getFloat("Key"));
  }

  /**
   * Test {@link COSDictionary#getFloat(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFloat(String)}
   */
  @Test
  @DisplayName("Test getFloat(String) with 'String'; given COSStream()")
  void testGetFloatWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new COSStream()).getFloat("Key"));
  }

  /**
   * Test {@link COSDictionary#getFlag(COSName, int)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFlag(COSName, int)}
   */
  @Test
  @DisplayName("Test getFlag(COSName, int); given COSDictionary(); when one; then return 'false'")
  void testGetFlag_givenCOSDictionary_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).getFlag(COSName.A, 1));
  }

  /**
   * Test {@link COSDictionary#getFlag(COSName, int)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFlag(COSName, int)}
   */
  @Test
  @DisplayName("Test getFlag(COSName, int); given COSDictionary(); when zero; then return 'true'")
  void testGetFlag_givenCOSDictionary_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).getFlag(COSName.A, 0));
  }

  /**
   * Test {@link COSDictionary#getFlag(COSName, int)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getFlag(COSName, int)}
   */
  @Test
  @DisplayName("Test getFlag(COSName, int); given COSStream(); when one; then return 'false'")
  void testGetFlag_givenCOSStream_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSStream()).getFlag(COSName.A, 1));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName, COSName)} with {@code COSName},
   * {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName, COSName) with 'COSName', 'COSName'; given COSDictionary(); when A")
  void testGetItemWithCOSNameCOSName_givenCOSDictionary_whenA() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getItem(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName, COSName)} with {@code COSName},
   * {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName, COSName) with 'COSName', 'COSName'; given COSDictionary(); when 'null'")
  void testGetItemWithCOSNameCOSName_givenCOSDictionary_whenNull() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getItem(COSName.A, null));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName, COSName)} with {@code COSName},
   * {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName, COSName) with 'COSName', 'COSName'; given COSStream(); when A")
  void testGetItemWithCOSNameCOSName_givenCOSStream_whenA() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getItem(COSName.A, COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName) with 'COSName'; given COSDictionary()")
  void testGetItemWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getItem(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(COSName)}
   */
  @Test
  @DisplayName("Test getItem(COSName) with 'COSName'; given COSStream()")
  void testGetItemWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getItem(COSName.A));
  }

  /**
   * Test {@link COSDictionary#getItem(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(String)}
   */
  @Test
  @DisplayName("Test getItem(String) with 'String'; given COSDictionary()")
  void testGetItemWithString_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getItem("Key"));
  }

  /**
   * Test {@link COSDictionary#getItem(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(String)}
   */
  @Test
  @DisplayName("Test getItem(String) with 'String'; given COSDictionary(COSDictionary) with dict is COSDictionary()")
  void testGetItemWithString_givenCOSDictionaryWithDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary(new COSDictionary())).getItem("Key"));
  }

  /**
   * Test {@link COSDictionary#getItem(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getItem(String)}
   */
  @Test
  @DisplayName("Test getItem(String) with 'String'; given COSStream()")
  void testGetItemWithString_givenCOSStream() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getItem("Key"));
  }

  /**
   * Test {@link COSDictionary#keySet()}.
   * <p>
   * Method under test: {@link COSDictionary#keySet()}
   */
  @Test
  @DisplayName("Test keySet()")
  void testKeySet() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).keySet().isEmpty());
  }

  /**
   * Test {@link COSDictionary#entrySet()}.
   * <p>
   * Method under test: {@link COSDictionary#entrySet()}
   */
  @Test
  @DisplayName("Test entrySet()")
  void testEntrySet() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).entrySet().isEmpty());
  }

  /**
   * Test {@link COSDictionary#getValues()}.
   * <p>
   * Method under test: {@link COSDictionary#getValues()}
   */
  @Test
  @DisplayName("Test getValues()")
  void testGetValues() {
    // Arrange, Act and Assert
    assertTrue((new COSDictionary()).getValues().isEmpty());
  }

  /**
   * Test {@link COSDictionary#accept(ICOSVisitor)}.
   * <ul>
   *   <li>Then calls {@link COSWriter#visitFromDictionary(COSDictionary)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then calls visitFromDictionary(COSDictionary)")
  void testAccept_thenCallsVisitFromDictionary() throws IOException {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromDictionary(Mockito.<COSDictionary>any());

    // Act
    cosDictionary.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromDictionary(isA(COSDictionary.class));
  }

  /**
   * Test {@link COSDictionary#accept(ICOSVisitor)}.
   * <ul>
   *   <li>When {@link COSWriter} {@link COSWriter#visitFromStream(COSStream)} does
   * nothing.</li>
   *   <li>Then calls {@link COSWriter#visitFromStream(COSStream)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); when COSWriter visitFromStream(COSStream) does nothing; then calls visitFromStream(COSStream)")
  void testAccept_whenCOSWriterVisitFromStreamDoesNothing_thenCallsVisitFromStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSWriter visitor = mock(COSWriter.class);
    doNothing().when(visitor).visitFromStream(Mockito.<COSStream>any());

    // Act
    cosStream.accept(visitor);

    // Assert that nothing has changed
    verify(visitor).visitFromStream(isA(COSStream.class));
  }

  /**
   * Test {@link COSDictionary#addAll(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#addAll(COSDictionary)}
   */
  @Test
  @DisplayName("Test addAll(COSDictionary); given COSDictionary(); when COSDictionary(); then COSDictionary() size is zero")
  void testAddAll_givenCOSDictionary_whenCOSDictionary_thenCOSDictionarySizeIsZero() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSDictionary dict = new COSDictionary();

    // Act
    cosDictionary.addAll(dict);

    // Assert
    assertEquals(0, dict.size());
    assertTrue(dict.getValues().isEmpty());
    assertTrue(dict.items.isEmpty());
  }

  /**
   * Test {@link COSDictionary#addAll(COSDictionary)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#addAll(COSDictionary)}
   */
  @Test
  @DisplayName("Test addAll(COSDictionary); given COSDictionary(); when COSStream(); then COSDictionary() Values size is one")
  void testAddAll_givenCOSDictionary_whenCOSStream_thenCOSDictionaryValuesSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSStream dict = new COSStream();

    // Act
    cosDictionary.addAll(dict);

    // Assert
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.items.size());
    assertEquals(1, dict.items.size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Test {@link COSDictionary#containsKey(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsKey(COSName)}
   */
  @Test
  @DisplayName("Test containsKey(COSName) with 'COSName'; given COSDictionary()")
  void testContainsKeyWithCOSName_givenCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).containsKey(COSName.A));
  }

  /**
   * Test {@link COSDictionary#containsKey(COSName)} with {@code COSName}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsKey(COSName)}
   */
  @Test
  @DisplayName("Test containsKey(COSName) with 'COSName'; given COSStream()")
  void testContainsKeyWithCOSName_givenCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new COSStream()).containsKey(COSName.A));
  }

  /**
   * Test {@link COSDictionary#containsKey(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code COSArray{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsKey(String)}
   */
  @Test
  @DisplayName("Test containsKey(String) with 'String'; given COSDictionary(); when 'COSArray{'")
  void testContainsKeyWithString_givenCOSDictionary_whenCOSArray() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).containsKey("COSArray{"));
  }

  /**
   * Test {@link COSDictionary#containsKey(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsKey(String)}
   */
  @Test
  @DisplayName("Test containsKey(String) with 'String'; given COSDictionary(); when 'Name'")
  void testContainsKeyWithString_givenCOSDictionary_whenName() {
    // Arrange, Act and Assert
    assertFalse((new COSDictionary()).containsKey("Name"));
  }

  /**
   * Test {@link COSDictionary#containsKey(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} addAll
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#containsKey(String)}
   */
  @Test
  @DisplayName("Test containsKey(String) with 'String'; given COSStream() addAll COSDictionary(); when 'Name'")
  void testContainsKeyWithString_givenCOSStreamAddAllCOSDictionary_whenName() {
    // Arrange
    COSStream cosStream = new COSStream();
    cosStream.addAll(new COSDictionary());

    // Act and Assert
    assertFalse(cosStream.containsKey("Name"));
  }

  /**
   * Test {@link COSDictionary#getObjectFromPath(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Obj Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getObjectFromPath(String)}
   */
  @Test
  @DisplayName("Test getObjectFromPath(String); given COSDictionary(COSDictionary) with dict is COSDictionary(); when 'Obj Path'")
  void testGetObjectFromPath_givenCOSDictionaryWithDictIsCOSDictionary_whenObjPath() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary(new COSDictionary())).getObjectFromPath("Obj Path"));
  }

  /**
   * Test {@link COSDictionary#getObjectFromPath(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Obj Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getObjectFromPath(String)}
   */
  @Test
  @DisplayName("Test getObjectFromPath(String); given COSDictionary(); when 'Obj Path'")
  void testGetObjectFromPath_givenCOSDictionary_whenObjPath() {
    // Arrange, Act and Assert
    assertNull((new COSDictionary()).getObjectFromPath("Obj Path"));
    assertNull((new COSDictionary()).getObjectFromPath("/Obj Path"));
  }

  /**
   * Test {@link COSDictionary#getObjectFromPath(String)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@code Obj Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getObjectFromPath(String)}
   */
  @Test
  @DisplayName("Test getObjectFromPath(String); given COSStream(); when 'Obj Path'")
  void testGetObjectFromPath_givenCOSStream_whenObjPath() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getObjectFromPath("Obj Path"));
  }

  /**
   * Test {@link COSDictionary#asUnmodifiableDictionary()}.
   * <p>
   * Method under test: {@link COSDictionary#asUnmodifiableDictionary()}
   */
  @Test
  @DisplayName("Test asUnmodifiableDictionary()")
  void testAsUnmodifiableDictionary() {
    // Arrange and Act
    COSDictionary actualAsUnmodifiableDictionaryResult = (new COSDictionary()).asUnmodifiableDictionary();

    // Assert
    assertTrue(actualAsUnmodifiableDictionaryResult instanceof UnmodifiableCOSDictionary);
    COSUpdateState updateState = actualAsUnmodifiableDictionaryResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualAsUnmodifiableDictionaryResult.getKey());
    assertEquals(0, actualAsUnmodifiableDictionaryResult.size());
    COSIncrement toIncrementResult = actualAsUnmodifiableDictionaryResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualAsUnmodifiableDictionaryResult.isDirect());
    assertFalse(actualAsUnmodifiableDictionaryResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(actualAsUnmodifiableDictionaryResult.getValues().isEmpty());
    assertTrue(((UnmodifiableCOSDictionary) actualAsUnmodifiableDictionaryResult).items.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSDictionary#toString()}
   *   <li>{@link COSDictionary#getUpdateState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    String actualToStringResult = cosDictionary.toString();
    COSUpdateState actualUpdateState = cosDictionary.getUpdateState();

    // Assert
    assertEquals("COSDictionary{}", actualToStringResult);
    assertNull(actualUpdateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualUpdateState.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualUpdateState.isAcceptingUpdates());
    assertFalse(actualUpdateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   * <p>
   * Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  void testGetIndirectObjectKeys() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert
    assertEquals(1, indirectObjects.size());
    assertSame(key, indirectObjects.get(0));
    assertSame(key, cosDictionary.getKey());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   * <p>
   * Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  void testGetIndirectObjectKeys2() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);

    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);

    indirectObjects.add(cosObjectKey);

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
    assertSame(cosObjectKey, indirectObjects.get(0));
    assertSame(key, cosDictionary.getKey());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); given COSDictionary(); then ArrayList() size is one")
  void testGetIndirectObjectKeys_givenCOSDictionary_thenArrayListSizeIsOne() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);

    indirectObjects.add(cosObjectKey);

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
    assertSame(cosObjectKey, indirectObjects.get(0));
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); given COSDictionary(); then ArrayList() size is two")
  void testGetIndirectObjectKeys_givenCOSDictionary_thenArrayListSizeIsTwo() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();

    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);

    indirectObjects.add(cosObjectKey);
    indirectObjects.add(new COSObjectKey(1L, 1));

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(2, indirectObjects.size());
    assertSame(cosObjectKey, indirectObjects.get(0));
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); given COSDictionary(); when ArrayList(); then ArrayList() Empty")
  void testGetIndirectObjectKeys_givenCOSDictionary_whenArrayList_thenArrayListEmpty() {
    // Arrange
    COSDictionary cosDictionary = new COSDictionary();
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosDictionary.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSDictionary#getIndirectObjectKeys(Collection)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSDictionary#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); given COSStream(); when ArrayList(); then ArrayList() Empty")
  void testGetIndirectObjectKeys_givenCOSStream_whenArrayList_thenArrayListEmpty() {
    // Arrange
    COSStream cosStream = new COSStream();
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosStream.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertTrue(indirectObjects.isEmpty());
  }
}
