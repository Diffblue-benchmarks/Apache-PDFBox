package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class FieldUtilsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldUtils.KeyValue#KeyValue(String, String)}
   *   <li>{@link FieldUtils.KeyValue#toString()}
   *   <li>{@link FieldUtils.KeyValue#getKey()}
   *   <li>{@link FieldUtils.KeyValue#getValue()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  void testToKeyValueList() {
    // Arrange
    ArrayList<String> key = new ArrayList<>();

    // Act
    List<FieldUtils.KeyValue> actualToKeyValueListResult = FieldUtils.toKeyValueList(key, new ArrayList<>());

    // Assert
    assertTrue(actualToKeyValueListResult.isEmpty());
  }

  /**
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  void testToKeyValueList2() {
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
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  void testToKeyValueList3() {
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
   * Method under test: {@link FieldUtils#toKeyValueList(List, List)}
   */
  @Test
  void testToKeyValueList4() {
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
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems() {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSBoolean.FALSE, 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems2() throws IOException {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSString.parseHex("0123456789ABCDEF"), 1);

    // Assert
    assertEquals(1, actualPairableItems.size());
    assertEquals("\u0001#Eg›«Íï", actualPairableItems.get(0));
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems3() {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(new COSArray(), 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldUtils.getPairableItems(COSBoolean.FALSE, 2));
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> FieldUtils.getPairableItems(COSBoolean.FALSE, -1));
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems6() throws IOException {
    // Arrange and Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(COSString.parseHex("42"), 1);

    // Assert
    assertEquals(1, actualPairableItems.size());
    assertEquals("B", actualPairableItems.get(0));
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems7() {
    // Arrange
    COSArray items = new COSArray();
    items.add(COSBoolean.FALSE);

    // Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(items, 1);

    // Assert
    assertTrue(actualPairableItems.isEmpty());
  }

  /**
   * Method under test: {@link FieldUtils#getPairableItems(COSBase, int)}
   */
  @Test
  void testGetPairableItems8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    COSArray items = new COSArray();
    items.add(object);

    // Act
    List<String> actualPairableItems = FieldUtils.getPairableItems(items, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPairableItems.isEmpty());
  }
}
