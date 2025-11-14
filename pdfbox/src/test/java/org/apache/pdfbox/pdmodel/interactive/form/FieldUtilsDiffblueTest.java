package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.interactive.form.FieldUtils.KeyValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FieldUtilsDiffblueTest {
  /**
   * Test KeyValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KeyValue#KeyValue(String, String)}
   *   <li>{@link KeyValue#toString()}
   *   <li>{@link KeyValue#getKey()}
   *   <li>{@link KeyValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test KeyValue getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void KeyValue.<init>(String, String)",
    "String KeyValue.getKey()",
    "String KeyValue.getValue()",
    "String KeyValue.toString()"
  })
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
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return first Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueList(List, List); given '42'; when ArrayList() add '42'; then return first Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.toKeyValueList(List, List)"})
  void testToKeyValueList_given42_whenArrayListAdd42_thenReturnFirstValueIs42() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();
    key.add("foo");

    ArrayList<String> value = new ArrayList<>();
    value.add("42");
    value.add("foo");

    // Act
    List<KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

    // Assert
    assertEquals(1, actualToKeyValueListResult.size());
    KeyValue getResult = actualToKeyValueListResult.get(0);
    assertEquals("42", getResult.getValue());
    assertEquals("foo", getResult.getKey());
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return first Value is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueList(List, List); given 'foo'; when ArrayList() add 'foo'; then return first Value is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.toKeyValueList(List, List)"})
  void testToKeyValueList_givenFoo_whenArrayListAddFoo_thenReturnFirstValueIsFoo() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();
    key.add("foo");

    ArrayList<String> value = new ArrayList<>();
    value.add("foo");

    // Act
    List<KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, value);

    // Assert
    assertEquals(1, actualToKeyValueListResult.size());
    KeyValue getResult = actualToKeyValueListResult.get(0);
    assertEquals("foo", getResult.getKey());
    assertEquals("foo", getResult.getValue());
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code Key}.
   *   <li>Then return size is eighteen.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName(
      "Test toKeyValueList(List, List); given 'Key'; when ArrayList() add 'Key'; then return size is eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    KeyValue getResult = actualToKeyValueListResult.get(1);
    assertEquals("42", getResult.getValue());
    KeyValue getResult2 = actualToKeyValueListResult.get(12);
    assertEquals("42", getResult2.getValue());
    KeyValue getResult3 = actualToKeyValueListResult.get(13);
    assertEquals("42", getResult3.getValue());
    KeyValue getResult4 = actualToKeyValueListResult.get(14);
    assertEquals("42", getResult4.getValue());
    KeyValue getResult5 = actualToKeyValueListResult.get(15);
    assertEquals("42", getResult5.getValue());
    KeyValue getResult6 = actualToKeyValueListResult.get(17);
    assertEquals("42", getResult6.getValue());
    KeyValue getResult7 = actualToKeyValueListResult.get(2);
    assertEquals("42", getResult7.getValue());
    KeyValue getResult8 = actualToKeyValueListResult.get(3);
    assertEquals("42", getResult8.getValue());
    KeyValue getResult9 = actualToKeyValueListResult.get(4);
    assertEquals("42", getResult9.getValue());
    KeyValue getResult10 = actualToKeyValueListResult.get(5);
    assertEquals("42", getResult10.getValue());
    KeyValue getResult11 = actualToKeyValueListResult.get(Short.SIZE);
    assertEquals("42", getResult11.getValue());
    assertEquals("Key", actualToKeyValueListResult.get(0).getKey());
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
  }

  /**
   * Test {@link FieldUtils#toKeyValueList(List, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  @DisplayName("Test toKeyValueList(List, List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then calls {@link COSObjectable#getCOSObject()}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); then calls getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_thenCallsGetCOSObject() {
    // Arrange
    COSObjectable cosObjectable = mock(COSObjectable.class);
    when(cosObjectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    ArrayList<COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(cosObjectable);

    // Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(new COSArray(cosObjectables), 0);

    // Assert
    verify(cosObjectable).getCOSObject();
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when FALSE; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenFalse_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSBoolean.FALSE, 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName(
      "Test getPairableItems(COSBase, int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> FieldUtils.getPairableItems(new COSArray(new ArrayList<>()), -1));
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   *
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName(
      "Test getPairableItems(COSBase, int); when parseHex '0123456789ABCDEF'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenParseHex0123456789abcdef_thenReturnSizeIsOne() throws IOException {
    // Arrange and Act
    List<String> actualPairableItems =
        FieldUtils.getPairableItems(COSString.parseHex("0123456789ABCDEF"), 1);

    // Assert
    assertEquals(1, actualPairableItems.size());
    assertEquals("\u0001#Eg›«Íï", actualPairableItems.get(0));
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> FieldUtils.getPairableItems(new COSArray(new ArrayList<>()), 2));
  }

  /**
   * Test {@link FieldUtils#getPairableItems(COSBase, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  @DisplayName("Test getPairableItems(COSBase, int); when zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldUtils.getPairableItems(COSBase, int)"})
  void testGetPairableItems_whenZero_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualPairableItems =
        FieldUtils.getPairableItems(new COSArray(new ArrayList<>()), 0);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }
}
