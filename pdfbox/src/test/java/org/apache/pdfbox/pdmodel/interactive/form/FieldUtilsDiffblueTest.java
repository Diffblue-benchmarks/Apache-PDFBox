package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.interactive.form.FieldUtils.KeyValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FieldUtilsDiffblueTest {
  /**
   * Test KeyValue getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyValue#KeyValue(String, String)}
   *   <li>{@link KeyValue#toString()}
   *   <li>{@link KeyValue#getKey()}
   *   <li>{@link KeyValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test KeyValue getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void KeyValue.<init>(String, String)", "String KeyValue.getKey()", "String KeyValue.getValue()",
      "String KeyValue.toString()"})
  void testKeyValueGettersAndSetters() {
    // Arrange and Act
    KeyValue actualKeyValue = new KeyValue("The Key", "42");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.toKeyValueList(List, List)"})
  void testToKeyValueList_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    List<KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.toKeyValueList(List, List)"})
  void testToKeyValueList_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    List<KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.toKeyValueList(List, List)"})
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
    List<KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

    // Assert
    assertEquals(18, actualToKeyValueListResult.size());
    KeyValue getResult = actualToKeyValueListResult.get(0);
    assertEquals("42", getResult.getValue());
    KeyValue getResult2 = actualToKeyValueListResult.get(1);
    assertEquals("42", getResult2.getValue());
    KeyValue getResult3 = actualToKeyValueListResult.get(12);
    assertEquals("42", getResult3.getValue());
    KeyValue getResult4 = actualToKeyValueListResult.get(13);
    assertEquals("42", getResult4.getValue());
    KeyValue getResult5 = actualToKeyValueListResult.get(14);
    assertEquals("42", getResult5.getValue());
    KeyValue getResult6 = actualToKeyValueListResult.get(15);
    assertEquals("42", getResult6.getValue());
    KeyValue getResult7 = actualToKeyValueListResult.get(17);
    assertEquals("42", getResult7.getValue());
    KeyValue getResult8 = actualToKeyValueListResult.get(2);
    assertEquals("42", getResult8.getValue());
    KeyValue getResult9 = actualToKeyValueListResult.get(3);
    assertEquals("42", getResult9.getValue());
    KeyValue getResult10 = actualToKeyValueListResult.get(4);
    assertEquals("42", getResult10.getValue());
    KeyValue getResult11 = actualToKeyValueListResult.get(5);
    assertEquals("42", getResult11.getValue());
    KeyValue getResult12 = actualToKeyValueListResult.get(Short.SIZE);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.toKeyValueList(List, List)"})
  void testToKeyValueList_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    // Act
    List<KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, new ArrayList<>());

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
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
   *   <li>Given parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); given parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_givenParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSArray items = new COSArray();
    items.add(COSString.parseHex("0123456789ABCDEF"));

    // Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(items, 1);

    // Assert
    assertEquals(1, actualPairableItems.size());
    assertEquals("\u0001#Eg›«Íï", actualPairableItems.get(0));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
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
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   *   <li>Then return first is {@code #Eg›«Íï}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when parseHex '0123456789ABCDEF'; then return first is '#Eg›«Íï'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenParseHex0123456789abcdef_thenReturnFirstIsEg() throws IOException {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSString.parseHex("0123456789ABCDEF"), 1);

    // Assert
    assertEquals(1, actualPairableItems.size());
    assertEquals("\u0001#Eg›«Íï", actualPairableItems.get(0));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldUtils.getPairableItems(COSBoolean.FALSE, 2));
  }
}
