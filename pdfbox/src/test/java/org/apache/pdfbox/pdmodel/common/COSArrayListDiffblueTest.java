package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSArrayListDiffblueTest {
  /**
   * Test {@link COSArrayList#COSArrayList()}.
   * <p>
   * Method under test: {@link COSArrayList#COSArrayList()}
   */
  @Test
  @DisplayName("Test new COSArrayList()")
  void testNewCOSArrayList() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>();

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#COSArrayList(COSDictionary, COSName)}.
   * <p>
   * Method under test: {@link COSArrayList#COSArrayList(COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(COSDictionary, COSName)")
  void testNewCOSArrayList2() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(new COSDictionary(), COSName.A);

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#COSArrayList(List, COSArray)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  @DisplayName("Test new COSArrayList(List, COSArray); given '42'; when ArrayList() add '42'; then return ArrayList()")
  void testNewCOSArrayList_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    actualList.add("42");

    // Act and Assert
    assertEquals(actualList, new COSArrayList<>(actualList, new COSArray()));
  }

  /**
   * Test {@link COSArrayList#COSArrayList(List, COSArray)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  @DisplayName("Test new COSArrayList(List, COSArray); given '42'; when ArrayList() add '42'; then return ArrayList()")
  void testNewCOSArrayList_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    actualList.add("42");
    actualList.add("42");

    // Act and Assert
    assertEquals(actualList, new COSArrayList<>(actualList, new COSArray()));
  }

  /**
   * Test
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); given COSObjectKey(long, int) with num is one and gen is one")
  void testNewCOSArrayList_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary item = new COSDictionary();
    item.setKey(new COSObjectKey(1L, 1));

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#COSArrayList(List, COSArray)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  @DisplayName("Test new COSArrayList(List, COSArray); when ArrayList(); then return ArrayList()")
  void testNewCOSArrayList_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();

    // Act and Assert
    assertEquals(actualList, new COSArrayList<>(actualList, new COSArray()));
  }

  /**
   * Test
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when COSArray()")
  void testNewCOSArrayList_whenCOSArray() {
    // Arrange
    COSArray item = new COSArray();

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when COSDictionary()")
  void testNewCOSArrayList_whenCOSDictionary() {
    // Arrange
    COSDictionary item = new COSDictionary();

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when COSObjectKey(long, int) with num is one and gen is one")
  void testNewCOSArrayList_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSObject item = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when FALSE")
  void testNewCOSArrayList_whenFalse() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>("Actual Object", COSBoolean.FALSE, new COSDictionary(),
        COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#size()}.
   * <p>
   * Method under test: {@link COSArrayList#size()}
   */
  @Test
  @DisplayName("Test size()")
  void testSize() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(0, objectList.size());
  }

  /**
   * Test {@link COSArrayList#isEmpty()}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given COSArrayList() add '42'; then return 'false'")
  void testIsEmpty_givenCOSArrayListAdd42_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#isEmpty()}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given COSArrayList(); then return 'true'")
  void testIsEmpty_givenCOSArrayList_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#contains(Object)}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given COSArrayList() add '42'; then return 'true'")
  void testContains_givenCOSArrayListAdd42_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertTrue(objectList.contains("42"));
  }

  /**
   * Test {@link COSArrayList#contains(Object)}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given COSArrayList(); then return 'false'")
  void testContains_givenCOSArrayList_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.contains("42"));
  }

  /**
   * Test {@link COSArrayList#iterator()}.
   * <p>
   * Method under test: {@link COSArrayList#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  void testIterator() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.iterator().hasNext());
  }

  /**
   * Test {@link COSArrayList#toArray()}.
   * <p>
   * Method under test: {@link COSArrayList#toArray()}
   */
  @Test
  @DisplayName("Test toArray()")
  void testToArray() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(0, objectList.toArray().length);
  }

  /**
   * Test {@link COSArrayList#add(int, Object)} with {@code index},
   * {@code element}.
   * <p>
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName("Test add(int, Object) with 'index', 'element'")
  void testAddWithIndexElement() {
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
   * Test {@link COSArrayList#add(int, Object)} with {@code index},
   * {@code element}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} second is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName("Test add(int, Object) with 'index', 'element'; when COSArray(); then COSArrayList() second is COSArray()")
  void testAddWithIndexElement_whenCOSArray_thenCOSArrayListSecondIsCOSArray() {
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
   * Test {@link COSArrayList#add(int, Object)} with {@code index},
   * {@code element}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} second is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName("Test add(int, Object) with 'index', 'element'; when COSDictionary(); then COSArrayList() second is COSDictionary()")
  void testAddWithIndexElement_whenCOSDictionary_thenCOSArrayListSecondIsCOSDictionary() {
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
   * Test {@link COSArrayList#add(int, Object)} with {@code index},
   * {@code element}.
   * <ul>
   *   <li>When {@code Element}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} second is {@code Element}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName("Test add(int, Object) with 'index', 'element'; when 'Element'; then COSArrayList() second is 'Element'")
  void testAddWithIndexElement_whenElement_thenCOSArrayListSecondIsElement() {
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
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   * <p>
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'o'")
  void testAddWithO() {
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
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'o'; when '42'; then COSArrayList() first is '42'")
  void testAddWithO_when42_thenCOSArrayListFirstIs42() {
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
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'o'; when COSArray(); then COSArrayList() first is COSArray()")
  void testAddWithO_whenCOSArray_thenCOSArrayListFirstIsCOSArray() {
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
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'o'; when COSDictionary(); then COSArrayList() first is COSDictionary()")
  void testAddWithO_whenCOSDictionary_thenCOSArrayListFirstIsCOSDictionary() {
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
   * Test {@link COSArrayList#remove(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int) with 'index'; given COSArrayList() add '42'; then COSArrayList() size is one")
  void testRemoveWithIndex_givenCOSArrayListAdd42_thenCOSArrayListSizeIsOne() {
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
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add '42'; when '42'; then COSArrayList() Empty")
  void testRemoveWithO_givenCOSArrayListAdd42_when42_thenCOSArrayListEmpty() {
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
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add '42'; when FALSE; then COSArrayList() size is one")
  void testRemoveWithO_givenCOSArrayListAdd42_whenFalse_thenCOSArrayListSizeIsOne() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove(COSBoolean.FALSE);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add '42'; when FALSE; then COSArrayList() size is two")
  void testRemoveWithO_givenCOSArrayListAdd42_whenFalse_thenCOSArrayListSizeIsTwo() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove(COSBoolean.FALSE);

    // Assert
    assertEquals(2, objectList.size());
    assertEquals("42", objectList.get(0));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add '42'; when ONE; then COSArrayList() size is one")
  void testRemoveWithO_givenCOSArrayListAdd42_whenOne_thenCOSArrayListSizeIsOne() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove(COSInteger.ONE);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add '42'; when ONE; then COSArrayList() size is two")
  void testRemoveWithO_givenCOSArrayListAdd42_whenOne_thenCOSArrayListSizeIsTwo() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove(COSInteger.ONE);

    // Assert
    assertEquals(2, objectList.size());
    assertEquals("42", objectList.get(0));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add
   * {@link COSInteger#ONE}.</li>
   *   <li>When {@link COSInteger#ONE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add ONE; when ONE; then return 'true'")
  void testRemoveWithO_givenCOSArrayListAddOne_whenOne_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add(COSInteger.ONE);
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove(COSInteger.ONE);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add
   * {@link COSInteger#THREE}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList() add THREE; then COSArrayList() first COSInteger")
  void testRemoveWithO_givenCOSArrayListAddThree_thenCOSArrayListFirstCOSInteger() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add(COSInteger.THREE);
    objectList.add("42");
    COSInteger cosInteger = COSInteger.ONE;

    // Act
    boolean actualRemoveResult = objectList.remove(cosInteger);

    // Assert
    assertEquals(2, objectList.size());
    Object getResult = objectList.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertFalse(actualRemoveResult);
    assertSame(cosInteger.THREE, getResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object) with 'o'; given COSArrayList(); when '42'; then COSArrayList() Empty")
  void testRemoveWithO_givenCOSArrayList_when42_thenCOSArrayListEmpty() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.remove("42"));
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#indexOf(Object)}.
   * <p>
   * Method under test: {@link COSArrayList#indexOf(Object)}
   */
  @Test
  @DisplayName("Test indexOf(Object)")
  void testIndexOf() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(-1, objectList.indexOf("42"));
  }

  /**
   * Test {@link COSArrayList#lastIndexOf(Object)}.
   * <p>
   * Method under test: {@link COSArrayList#lastIndexOf(Object)}
   */
  @Test
  @DisplayName("Test lastIndexOf(Object)")
  void testLastIndexOf() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(-1, objectList.lastIndexOf("42"));
  }

  /**
   * Test {@link COSArrayList#listIterator()}.
   * <p>
   * Method under test: {@link COSArrayList#listIterator()}
   */
  @Test
  @DisplayName("Test listIterator()")
  void testListIterator() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.listIterator().hasNext());
  }

  /**
   * Test {@link COSArrayList#listIterator(int)} with {@code int}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#listIterator(int)}
   */
  @Test
  @DisplayName("Test listIterator(int) with 'int'; given COSArrayList() add '42'; then return not hasNext")
  void testListIteratorWithInt_givenCOSArrayListAdd42_thenReturnNotHasNext() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.listIterator(1).hasNext());
  }

  /**
   * Test {@link COSArrayList#subList(int, int)}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#subList(int, int)}
   */
  @Test
  @DisplayName("Test subList(int, int); given COSArrayList() add '42'; then return Empty")
  void testSubList_givenCOSArrayListAdd42_thenReturnEmpty() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertTrue(objectList.subList(1, 1).isEmpty());
  }

  /**
   * Test {@link COSArrayList#containsAll(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  @DisplayName("Test containsAll(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  void testContainsAll_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act and Assert
    assertFalse(objectList.containsAll(c));
  }

  /**
   * Test {@link COSArrayList#containsAll(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  @DisplayName("Test containsAll(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  void testContainsAll_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act and Assert
    assertFalse(objectList.containsAll(c));
  }

  /**
   * Test {@link COSArrayList#containsAll(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  @DisplayName("Test containsAll(Collection); when ArrayList(); then return 'true'")
  void testContainsAll_whenArrayList_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertTrue(objectList.containsAll(new ArrayList<>()));
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'")
  void testAddAllWithC() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    c.add(cosObject);

    // Act
    objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertSame(cosObject, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; given '42'; when ArrayList() add '42'; then COSArrayList() first is '42'")
  void testAddAllWithC_given42_whenArrayListAdd42_thenCOSArrayListFirstIs42() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", objectList.get(0));
    assertTrue(actualAddAllResult);
    assertEquals(objectList, c);
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; given '42'; when ArrayList() add '42'; then COSArrayList() size is two")
  void testAddAllWithC_given42_whenArrayListAdd42_thenCOSArrayListSizeIsTwo() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act
    objectList.addAll(c);

    // Assert
    assertEquals(2, objectList.size());
    assertEquals("42", objectList.get(0));
    assertEquals("42", objectList.get(1));
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; given COSArray(); then COSArrayList() first is COSArray()")
  void testAddAllWithC_givenCOSArray_thenCOSArrayListFirstIsCOSArray() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    COSArray cosArray = new COSArray();
    c.add(cosArray);

    // Act
    objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertSame(cosArray, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; given COSDictionary(); then COSArrayList() first is COSDictionary()")
  void testAddAllWithC_givenCOSDictionary_thenCOSArrayListFirstIsCOSDictionary() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    c.add(cosDictionary);

    // Act
    objectList.addAll(c);

    // Assert
    assertEquals(1, c.size());
    assertEquals(1, objectList.size());
    assertSame(cosDictionary, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; given FALSE; when ArrayList() add FALSE; then return 'true'")
  void testAddAllWithC_givenFalse_whenArrayListAddFalse_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    ArrayList<Object> c = new ArrayList<>();
    c.add(COSBoolean.FALSE);

    // Act
    boolean actualAddAllResult = objectList.addAll(c);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddAllResult);
    assertEquals(objectList, c);
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; when ArrayList(); then return 'false'")
  void testAddAllWithC_whenArrayList_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    ArrayList<Object> c = new ArrayList<>();

    // Act and Assert
    assertFalse(objectList.addAll(c));
    assertTrue(objectList.isEmpty());
    assertEquals(objectList, c);
  }

  /**
   * Test {@link COSArrayList#addAll(int, Collection)} with {@code index},
   * {@code c}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#addAll(int, Collection)}
   */
  @Test
  @DisplayName("Test addAll(int, Collection) with 'index', 'c'; given COSArrayList() add '42'; when ArrayList(); then return 'false'")
  void testAddAllWithIndexC_givenCOSArrayListAdd42_whenArrayList_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.addAll(1, new ArrayList<>()));
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List)")
  void testConverterToCOSArray() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    cosObjectableList.add(cosObject);
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(2, toListResult.size());
    assertSame(cosObject, toListResult.get(0));
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return toList first toHexString is {@code 3432}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given '42'; then return toList first toHexString is '3432'")
  void testConverterToCOSArray_given42_thenReturnToListFirstToHexStringIs3432() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add("42");
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given 'A'; then throw IllegalArgumentException")
  void testConverterToCOSArray_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add((byte) 'A');
    cosObjectableList.add(2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> COSArrayList.converterToCOSArray(cosObjectableList));
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>Then toList first return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given COSArray(); then toList first return COSArray")
  void testConverterToCOSArray_givenCOSArray_thenToListFirstReturnCOSArray() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    COSArray cosArray = new COSArray();
    cosObjectableList.add(cosArray);
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertSame(cosArray, getResult);
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return toList first is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given COSDictionary(); then return toList first is COSDictionary()")
  void testConverterToCOSArray_givenCOSDictionary_thenReturnToListFirstIsCOSDictionary() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    cosObjectableList.add(cosDictionary);
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(2, toListResult.size());
    assertSame(cosDictionary, toListResult.get(0));
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then toList first return {@link COSNull}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given 'null'; then toList first return COSNull")
  void testConverterToCOSArray_givenNull_thenToListFirstReturnCOSNull() {
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
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then toList first return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given ten; then toList first return COSFloat")
  void testConverterToCOSArray_givenTen_thenToListFirstReturnCOSFloat() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(10.0d);
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>Then toList first return {@link COSFloat}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given ten; then toList first return COSFloat")
  void testConverterToCOSArray_givenTen_thenToListFirstReturnCOSFloat2() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(10.0f);
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then toList first return {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given two; then toList first return COSInteger")
  void testConverterToCOSArray_givenTwo_thenToListFirstReturnCOSInteger() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(2);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArrayList.converterToCOSArray(cosObjectableList).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); when ArrayList(); then return toList Empty")
  void testConverterToCOSArray_whenArrayList_thenReturnToListEmpty() {
    // Arrange, Act and Assert
    assertTrue(COSArrayList.converterToCOSArray(new ArrayList<>()).toList().isEmpty());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); when 'null'; then return 'null'")
  void testConverterToCOSArray_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(COSArrayList.converterToCOSArray(null));
  }

  /**
   * Test {@link COSArrayList#removeAll(Collection)}.
   * <p>
   * Method under test: {@link COSArrayList#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection)")
  void testRemoveAll() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.removeAll(new ArrayList<>()));
  }

  /**
   * Test {@link COSArrayList#retainAll(Collection)}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given COSArrayList() add '42'; then return 'true'")
  void testRetainAll_givenCOSArrayListAdd42_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    ArrayList<Object> c = new ArrayList<>();

    // Act
    boolean actualRetainAllResult = objectList.retainAll(c);

    // Assert
    assertTrue(objectList.isEmpty());
    assertTrue(actualRetainAllResult);
    assertEquals(objectList, c);
  }

  /**
   * Test {@link COSArrayList#retainAll(Collection)}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given COSArrayList(); then return 'false'")
  void testRetainAll_givenCOSArrayList_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    ArrayList<Object> c = new ArrayList<>();

    // Act and Assert
    assertFalse(objectList.retainAll(c));
    assertTrue(objectList.isEmpty());
    assertEquals(objectList, c);
  }

  /**
   * Test {@link COSArrayList#equals(Object)}, and
   * {@link COSArrayList#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSArrayList#equals(Object)}
   *   <li>{@link COSArrayList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link COSArrayList#equals(Object)}, and
   * {@link COSArrayList#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSArrayList#equals(Object)}
   *   <li>{@link COSArrayList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(objectList, objectList);
    int expectedHashCodeResult = objectList.hashCode();
    assertEquals(expectedHashCodeResult, objectList.hashCode());
  }

  /**
   * Test {@link COSArrayList#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertNotEquals(objectList, new COSArrayList<>());
  }

  /**
   * Test {@link COSArrayList#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertNotEquals(objectList, null);
  }

  /**
   * Test {@link COSArrayList#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertNotEquals(objectList, "Different type to COSArrayList");
  }

  /**
   * Test {@link COSArrayList#get(int)}.
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSArrayList#get(int)}
   */
  @Test
  @DisplayName("Test get(int); given COSArrayList() add '42'; then return '42'")
  void testGet_givenCOSArrayListAdd42_thenReturn42() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    assertEquals("42", objectList.get(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSArrayList#toString()}
   *   <li>{@link COSArrayList#toList()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act
    String actualToStringResult = objectList.toString();

    // Assert
    assertEquals("COSArrayList{COSArray{[]}}", actualToStringResult);
    assertTrue(objectList.toList().toList().isEmpty());
  }
}
