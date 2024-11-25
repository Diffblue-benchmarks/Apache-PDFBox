package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FieldUtilsDiffblueTest {
  /**
   * Test KeyValue getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldUtils.KeyValue#KeyValue(String, String)}
   *   <li>{@link FieldUtils.KeyValue#toString()}
   *   <li>{@link FieldUtils.KeyValue#getKey()}
   *   <li>{@link FieldUtils.KeyValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test KeyValue getters and setters")
  void testKeyValueGettersAndSetters() {
    // Arrange and Act
    FieldUtils.KeyValue actualKeyValue = new FieldUtils.KeyValue("The Key", "42");
    String actualToStringResult = actualKeyValue.toString();
    String actualKey = actualKeyValue.getKey();

    // Assert
    assertEquals("(The Key, 42)", actualToStringResult);
    assertEquals("42", actualKeyValue.getValue());
    assertEquals("The Key", actualKey);
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName("Test toKeyValueList(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  void testToKeyValueList_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    List<FieldUtils.KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

    // Assert
    assertTrue(actualToKeyValueListResult.isEmpty());
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName("Test toKeyValueList(List, List); given 'foo'; when ArrayList() add 'foo'; then return Empty")
  void testToKeyValueList_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    List<FieldUtils.KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

    // Assert
    assertTrue(actualToKeyValueListResult.isEmpty());
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code Key}.</li>
   *   <li>Then return size is eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName("Test toKeyValueList(List, List); given 'Key'; when ArrayList() add 'Key'; then return size is eighteen")
  void testToKeyValueList_givenKey_whenArrayListAddKey_thenReturnSizeIsEighteen() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");
    key.add("Key");

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");
    value.add("42");

    // Act
    List<FieldUtils.KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

    // Assert
    assertEquals(18, actualToKeyValueListResult.size());
    FieldUtils.KeyValue getResult = actualToKeyValueListResult.get(0);
    assertEquals("42", getResult.getValue());
    FieldUtils.KeyValue getResult2 = actualToKeyValueListResult.get(1);
    assertEquals("42", getResult2.getValue());
    FieldUtils.KeyValue getResult3 = actualToKeyValueListResult.get(12);
    assertEquals("42", getResult3.getValue());
    FieldUtils.KeyValue getResult4 = actualToKeyValueListResult.get(13);
    assertEquals("42", getResult4.getValue());
    FieldUtils.KeyValue getResult5 = actualToKeyValueListResult.get(14);
    assertEquals("42", getResult5.getValue());
    FieldUtils.KeyValue getResult6 = actualToKeyValueListResult.get(15);
    assertEquals("42", getResult6.getValue());
    FieldUtils.KeyValue getResult7 = actualToKeyValueListResult.get(17);
    assertEquals("42", getResult7.getValue());
    FieldUtils.KeyValue getResult8 = actualToKeyValueListResult.get(2);
    assertEquals("42", getResult8.getValue());
    FieldUtils.KeyValue getResult9 = actualToKeyValueListResult.get(3);
    assertEquals("42", getResult9.getValue());
    FieldUtils.KeyValue getResult10 = actualToKeyValueListResult.get(4);
    assertEquals("42", getResult10.getValue());
    FieldUtils.KeyValue getResult11 = actualToKeyValueListResult.get(5);
    assertEquals("42", getResult11.getValue());
    FieldUtils.KeyValue getResult12 = actualToKeyValueListResult.get(Short.SIZE);
    assertEquals("42", getResult12.getValue());
    assertEquals("Key", getResult.getKey());
    assertEquals("Key", getResult2.getKey());
    assertEquals("Key", getResult3.getKey());
    assertEquals("Key", getResult4.getKey());
    assertEquals("Key", getResult5.getKey());
    assertEquals("Key", getResult6.getKey());
    assertEquals("Key", getResult7.getKey());
    assertEquals("Key", getResult8.getKey());
    assertEquals("Key", getResult9.getKey());
    assertEquals("Key", getResult10.getKey());
    assertEquals("Key", getResult11.getKey());
    assertEquals("Key", getResult12.getKey());
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName("Test toKeyValueList(List, List); when ArrayList(); then return Empty")
  void testToKeyValueList_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    // Act
    List<FieldUtils.KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, new ArrayList<>());

    // Assert
    assertTrue(actualToKeyValueListResult.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); given COSArray(); when COSArray() add COSArray(); then return Empty")
  void testGetPairableItems_givenCOSArray_whenCOSArrayAddCOSArray_thenReturnEmpty() {
    // Arrange
    COSArray items = new COSArray();
    items.add((COSBase) new COSArray());

    // Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(items, 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); given FALSE; when COSArray() add FALSE; then return Empty")
  void testGetPairableItems_givenFalse_whenCOSArrayAddFalse_thenReturnEmpty() {
    // Arrange
    COSArray items = new COSArray();
    items.add(COSBoolean.FALSE);

    // Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(items, 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when COSArray(); then return Empty")
  void testGetPairableItems_whenCOSArray_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(new COSArray(), 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when FALSE; then return Empty")
  void testGetPairableItems_whenFalse_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSBoolean.FALSE, 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when minus one; then throw IllegalArgumentException")
  void testGetPairableItems_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldUtils.getPairableItems(COSBoolean.FALSE, -1));
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then return first is {@code B}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when parseHex '42'; then return first is 'B'")
  void testGetPairableItems_whenParseHex42_thenReturnFirstIsB() throws IOException {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSString.parseHex("42"), 1);

    // Assert
    assertEquals(1, actualPairableItems.size());
    assertEquals("B", actualPairableItems.get(0));
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when two; then throw IllegalArgumentException")
  void testGetPairableItems_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldUtils.getPairableItems(COSBoolean.FALSE, 2));
  }
}
