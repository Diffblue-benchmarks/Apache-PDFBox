package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class COSArrayListDiffblueTest {
  /**
   * Method under test: {@link COSArrayList#size()}
   */
  @Test
  void testSize() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(0, objectList.size());
  }

  /**
   * Method under test: {@link COSArrayList#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertTrue(objectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#isEmpty()}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#contains(Object)}
   */
  @Test
  void testContains() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.contains("42"));
  }

  /**
   * Method under test: {@link COSArrayList#contains(Object)}
   */
  @Test
  void testContains2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertTrue(objectList.contains("42"));
  }

  /**
   * Method under test: {@link COSArrayList#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.iterator().hasNext());
  }

  /**
   * Method under test: {@link COSArrayList#toArray()}
   */
  @Test
  void testToArray() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(0, objectList.toArray().length);
  }

  /**
   * Method under test: {@link COSArrayList#toArray(Object[])}
   */
  @Test
  void testToArray2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    Object[] a = new Object[]{"42"};

    // Act
    Object[] actualToArrayResult = objectList.toArray(a);

    // Assert
    assertNull(actualToArrayResult[0]);
    assertNull(a[0]);
    assertEquals(1, actualToArrayResult.length);
    assertEquals(1, a.length);
    assertSame(a, actualToArrayResult);
  }

  /**
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  void testAdd() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act
    objectList.add(1, "Element");

    // Assert
    assertEquals(2, objectList.size());
    assertEquals("Element", objectList.get(1));
  }

  /**
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  void testAdd2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    objectList.add(1, cosDictionary);

    // Assert
    assertEquals(2, objectList.size());
    assertSame(cosDictionary, objectList.get(1));
  }

  /**
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  void testAdd3() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    COSArray cosArray = new COSArray();

    // Act
    objectList.add(1, cosArray);

    // Assert
    assertEquals(2, objectList.size());
    assertSame(cosArray, objectList.get(1));
  }

  /**
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  void testAdd4() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    objectList.add(1, cosObject);

    // Assert
    assertEquals(2, objectList.size());
    assertSame(cosObject, objectList.get(1));
  }

  /**
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  void testAdd5() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act
    boolean actualAddResult = objectList.add("42");

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  void testAdd6() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();

    // Act
    boolean actualAddResult = objectList.add(cosDictionary);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(cosDictionary, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  void testAdd7() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    COSArray cosArray = new COSArray();

    // Act
    boolean actualAddResult = objectList.add(cosArray);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(cosArray, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  void testAdd8() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    boolean actualAddResult = objectList.add(cosObject);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(cosObject, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#remove(int)}
   */
  @Test
  void testRemove() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    Object actualRemoveResult = objectList.remove(1);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", actualRemoveResult);
  }

  /**
   * Method under test: {@link COSArrayList#remove(int)}
   */
  @Test
  void testRemove2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add(cosDocument);
    objectList.add("42");

    // Act
    Object actualRemoveResult = objectList.remove(1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, objectList.size());
    assertEquals("42", actualRemoveResult);
  }

  /**
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  void testRemove3() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.remove("42"));
    assertTrue(objectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  void testRemove4() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove("42");

    // Assert
    assertTrue(objectList.isEmpty());
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  void testRemove5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add(cosDocument);

    // Act
    boolean actualRemoveResult = objectList.remove("42");

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, objectList.size());
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link COSArrayList#indexOf(Object)}
   */
  @Test
  void testIndexOf() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(-1, objectList.indexOf("42"));
  }

  /**
   * Method under test: {@link COSArrayList#lastIndexOf(Object)}
   */
  @Test
  void testLastIndexOf() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(-1, objectList.lastIndexOf("42"));
  }

  /**
   * Method under test: {@link COSArrayList#listIterator()}
   */
  @Test
  void testListIterator() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.listIterator().hasNext());
  }

  /**
   * Method under test: {@link COSArrayList#listIterator(int)}
   */
  @Test
  void testListIterator2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.listIterator(1).hasNext());
  }

  /**
   * Method under test: {@link COSArrayList#subList(int, int)}
   */
  @Test
  void testSubList() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertTrue(objectList.subList(1, 1).isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  void testContainsAll() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertTrue(objectList.containsAll(new ArrayList<>()));
  }

  /**
   * Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  void testContainsAll2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertFalse(objectList.containsAll(c));
  }

  /**
   * Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  void testContainsAll3() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertFalse(objectList.containsAll(c));
  }

  /**
   * Method under test: {@link COSArrayList#addAll(int, Collection)}
   */
  @Test
  void testAddAll() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.addAll(1, new ArrayList<>()));
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    ArrayList<Object> c = new ArrayList<>();

    // Act and Assert
    assertFalse(objectList.addAll(c));
    assertTrue(c.isEmpty());
    assertTrue(objectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll3() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
    assertEquals(1, c.size());
    assertTrue(actualAddAllResult);
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll4() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(2, objectList.size());
    assertEquals("42", objectList.get(0));
    assertEquals("42", objectList.get(1));
    assertTrue(actualAddAllResult);
    assertEquals(objectList, c);
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll5() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add(COSBoolean.FALSE);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    Object expectedGetResult = c.get(0);
    assertSame(expectedGetResult, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll6() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    COSArray cosArray = new COSArray();
    c.add(cosArray);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    assertSame(cosArray, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll7() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    c.add(cosDictionary);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    assertSame(cosDictionary, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  void testAddAll8() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    c.add(cosObject);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    assertSame(cosObject, objectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  void testConverterToCOSArray() {
    // Arrange, Act and Assert
    assertTrue(COSArrayList.converterToCOSArray(new ArrayList<>()).toList().isEmpty());
    assertNull(COSArrayList.converterToCOSArray(null));
    assertTrue(COSArrayList.converterToCOSArray(new COSArrayList<>()).toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  void testConverterToCOSArray2() {
    // Arrange
    ArrayList<?> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(null);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
  }

  /**
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  void testConverterToCOSArray3() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add((byte) 'A');
    cosObjectableList.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> COSArrayList.converterToCOSArray(cosObjectableList));
  }

  /**
   * Method under test: {@link COSArrayList#removeAll(Collection)}
   */
  @Test
  void testRemoveAll() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.removeAll(new ArrayList<>()));
  }

  /**
   * Method under test: {@link COSArrayList#retainAll(Collection)}
   */
  @Test
  void testRetainAll() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    ArrayList<Object> c = new ArrayList<>();

    // Act and Assert
    assertFalse(objectList.retainAll(c));
    assertTrue(c.isEmpty());
    assertTrue(objectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#retainAll(Collection)}
   */
  @Test
  void testRetainAll2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    ArrayList<Object> c = new ArrayList<>();

    // Act
    boolean actualRetainAllResult = objectList.retainAll(c);

    // Assert
    assertTrue(c.isEmpty());
    assertTrue(objectList.isEmpty());
    assertTrue(actualRetainAllResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSArrayList#equals(Object)}
   *   <li>{@link COSArrayList#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    COSArrayList<Object> objectList2 = new COSArrayList<>();

    // Act and Assert
    assertEquals(objectList, objectList2);
    int expectedHashCodeResult = objectList.hashCode();
    assertEquals(expectedHashCodeResult, objectList2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSArrayList#equals(Object)}
   *   <li>{@link COSArrayList#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(objectList, objectList);
    int expectedHashCodeResult = objectList.hashCode();
    assertEquals(expectedHashCodeResult, objectList.hashCode());
  }

  /**
   * Method under test: {@link COSArrayList#get(int)}
   */
  @Test
  void testGet() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    assertEquals("42", objectList.get(1));
  }

  /**
   * Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertNotEquals(objectList, new COSArrayList<>());
  }

  /**
   * Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertNotEquals(objectList, null);
  }

  /**
   * Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertNotEquals(objectList, "Different type to COSArrayList");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSArrayList#toString()}
   *   <li>{@link COSArrayList#toList()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act
    String actualToStringResult = objectList.toString();

    // Assert
    assertEquals("COSArrayList{COSArray{[]}}", actualToStringResult);
    assertTrue(objectList.toList().toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#COSArrayList()}
   */
  @Test
  void testNewCOSArrayList() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>();

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  void testNewCOSArrayList2() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", COSBoolean.FALSE, new COSDictionary(),
        COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  void testNewCOSArrayList3() {
    // Arrange
    COSDictionary item = new COSDictionary();

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  void testNewCOSArrayList4() {
    // Arrange
    COSArray item = new COSArray();

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  void testNewCOSArrayList5() {
    // Arrange
    COSObject item = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  void testNewCOSArrayList6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray item = new COSArray();
    item.add(object);

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  void testNewCOSArrayList7() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(actualList, new COSArray());

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  void testNewCOSArrayList8() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    actualList.add("42");

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(actualList, new COSArray());

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("42", actualObjectList.get(0));
  }

  /**
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  void testNewCOSArrayList9() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    actualList.add("42");
    actualList.add("42");

    // Act and Assert
    assertEquals(actualList, new COSArrayList<>(actualList, new COSArray()));
  }

  /**
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  void testNewCOSArrayList10() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(actualList, cosArray);

    // Assert
    verify(object).getCOSObject();
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Method under test: {@link COSArrayList#COSArrayList(COSDictionary, COSName)}
   */
  @Test
  void testNewCOSArrayList11() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(new COSDictionary(), COSName.A);

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }
}
