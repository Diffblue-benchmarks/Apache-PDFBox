package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.pdmodel.PDDestinationNameTreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSArrayListDiffblueTest {
  /**
   * Test {@link COSArrayList#COSArrayList()}.
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList()}
   */
  @Test
  @DisplayName("Test new COSArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>()"})
  void testNewCOSArrayList() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>();

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#COSArrayList(COSDictionary, COSName)}.
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(COSDictionary, COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(COSDictionary, COSName)"})
  void testNewCOSArrayList2() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(new COSDictionary(), COSName.A);

    // Assert
    assertTrue(actualObjectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#COSArrayList(List, COSArray)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new COSArrayList(List, COSArray); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(List, COSArray)"})
  void testNewCOSArrayList_given42_whenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    actualList.add("42");

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(actualList, new COSArray());

    // Assert
    assertEquals(actualList, actualObjectList);
  }

  /**
   * Test {@link COSArrayList#COSArrayList(List, COSArray)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new COSArrayList(List, COSArray); given '42'; when ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(List, COSArray)"})
  void testNewCOSArrayList_given42_whenArrayListAdd42_thenReturnArrayList2() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();
    actualList.add("42");
    actualList.add("42");

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(actualList, new COSArray());

    // Assert
    assertEquals(actualList, actualObjectList);
  }

  /**
   * Test {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary,
   * COSName)}
   */
  @Test
  @DisplayName(
      "Test new COSArrayList(Object, COSBase, COSDictionary, COSName); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(Object, COSBase, COSDictionary, COSName)"})
  void testNewCOSArrayList_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary item = new COSDictionary();
    item.setKey(new COSObjectKey(1L, 1));

    // Act
    COSArrayList<Object> actualObjectList =
        new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#COSArrayList(List, COSArray)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(List, COSArray)}
   */
  @Test
  @DisplayName("Test new COSArrayList(List, COSArray); when ArrayList(); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(List, COSArray)"})
  void testNewCOSArrayList_whenArrayList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> actualList = new ArrayList<>();

    // Act
    COSArrayList<Object> actualObjectList = new COSArrayList<>(actualList, new COSArray());

    // Assert
    assertEquals(actualList, actualObjectList);
  }

  /**
   * Test {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary,
   * COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(Object, COSBase, COSDictionary, COSName)"})
  void testNewCOSArrayList_whenCOSArray() {
    // Arrange
    COSArray item = new COSArray();

    // Act
    COSArrayList<Object> actualObjectList =
        new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary,
   * COSName)}
   */
  @Test
  @DisplayName(
      "Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(Object, COSBase, COSDictionary, COSName)"})
  void testNewCOSArrayList_whenCOSDictionary() {
    // Arrange
    COSDictionary item = new COSDictionary();

    // Act
    COSArrayList<Object> actualObjectList =
        new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary,
   * COSName)}
   */
  @Test
  @DisplayName(
      "Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(Object, COSBase, COSDictionary, COSName)"})
  void testNewCOSArrayList_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSObject item = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSArrayList<Object> actualObjectList =
        new COSArrayList<>("Actual Object", item, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#COSArrayList(Object, COSBase, COSDictionary,
   * COSName)}
   */
  @Test
  @DisplayName("Test new COSArrayList(Object, COSBase, COSDictionary, COSName); when FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.<init>(Object, COSBase, COSDictionary, COSName)"})
  void testNewCOSArrayList_whenFalse() {
    // Arrange and Act
    COSArrayList<Object> actualObjectList =
        new COSArrayList<>("Actual Object", COSBoolean.FALSE, new COSDictionary(), COSName.A);

    // Assert
    assertEquals(1, actualObjectList.size());
    assertEquals("Actual Object", actualObjectList.get(0));
  }

  /**
   * Test {@link COSArrayList#size()}.
   *
   * <p>Method under test: {@link COSArrayList#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArrayList.size()"})
  void testSize() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(0, objectList.size());
  }

  /**
   * Test {@link COSArrayList#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given COSArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.isEmpty()"})
  void testIsEmpty_givenCOSArrayListAdd42_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given COSArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.isEmpty()"})
  void testIsEmpty_givenCOSArrayList_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given COSArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.contains(Object)"})
  void testContains_givenCOSArrayListAdd42_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertTrue(objectList.contains("42"));
  }

  /**
   * Test {@link COSArrayList#contains(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#contains(Object)}
   */
  @Test
  @DisplayName("Test contains(Object); given COSArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.contains(Object)"})
  void testContains_givenCOSArrayList_thenReturnFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.contains("42"));
  }

  /**
   * Test {@link COSArrayList#iterator()}.
   *
   * <p>Method under test: {@link COSArrayList#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator COSArrayList.iterator()"})
  void testIterator() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.iterator().hasNext());
  }

  /**
   * Test {@link COSArrayList#toArray()}.
   *
   * <p>Method under test: {@link COSArrayList#toArray()}
   */
  @Test
  @DisplayName("Test toArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] COSArrayList.toArray()"})
  void testToArray() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(0, objectList.toArray().length);
  }

  /**
   * Test {@link COSArrayList#toArray(Object[])} with {@code Object[]}.
   *
   * <p>Method under test: {@link COSArrayList#toArray(Object[])}
   */
  @Test
  @DisplayName("Test toArray(Object[]) with 'Object[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] COSArrayList.toArray(Object[])"})
  void testToArrayWithObject() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    Object[] a = new Object[] {"42"};

    // Act
    Object[] actualToArrayResult = objectList.toArray(a);

    // Assert
    assertNull(a[0]);
    assertEquals(1, a.length);
    assertSame(a, actualToArrayResult);
  }

  /**
   * Test {@link COSArrayList#add(int, Object)} with {@code index}, {@code element}.
   *
   * <p>Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName("Test add(int, Object) with 'index', 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.add(int, Object)"})
  void testAddWithIndexElement() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(new COSObjectKey(1L, 1));
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Act
    objectList.add(1, pdDestinationNameTreeNode);

    // Assert
    assertEquals(2, objectList.size());
    assertSame(pdDestinationNameTreeNode, objectList.get(1));
  }

  /**
   * Test {@link COSArrayList#add(int, Object)} with {@code index}, {@code element}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSArrayList#COSArrayList()} second is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName(
      "Test add(int, Object) with 'index', 'element'; when COSArray(); then COSArrayList() second is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.add(int, Object)"})
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
   * Test {@link COSArrayList#add(int, Object)} with {@code index}, {@code element}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSArrayList#COSArrayList()} second is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName(
      "Test add(int, Object) with 'index', 'element'; when COSDictionary(); then COSArrayList() second is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.add(int, Object)"})
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
   * Test {@link COSArrayList#add(int, Object)} with {@code index}, {@code element}.
   *
   * <ul>
   *   <li>When {@code Element}.
   *   <li>Then {@link COSArrayList#COSArrayList()} second is {@code Element}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(int, Object)}
   */
  @Test
  @DisplayName(
      "Test add(int, Object) with 'index', 'element'; when 'Element'; then COSArrayList() second is 'Element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArrayList.add(int, Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object) with 'o'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.add(Object)"})
  void testAddWithO_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(new COSObjectKey(1L, 1));
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Act
    boolean actualAddResult = objectList.add(pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} Direct is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object) with 'o'; given 'false'; when COSDictionary(COSDictionary) with dict is COSDictionary() Direct is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.add(Object)"})
  void testAddWithO_givenFalse_whenCOSDictionaryWithDictIsCOSDictionaryDirectIsFalse() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(null);
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Act
    boolean actualAddResult = objectList.add(pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object) with 'o'; given 'true'; when COSDictionary(COSDictionary) with dict is COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.add(Object)"})
  void testAddWithO_givenTrue_whenCOSDictionaryWithDictIsCOSDictionaryDirectIsTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(true);
    dic.setKey(null);
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Act
    boolean actualAddResult = objectList.add(pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertTrue(actualAddResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#add(Object)} with {@code o}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName("Test add(Object) with 'o'; when '42'; then COSArrayList() first is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.add(Object)"})
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
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#add(Object)}
   */
  @Test
  @DisplayName(
      "Test add(Object) with 'o'; when COSArray(); then COSArrayList() first is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.add(Object)"})
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
   * Test {@link COSArrayList#remove(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int) with 'index'; given COSArrayList() add '42'; then COSArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object COSArrayList.remove(int)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>When {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add '42'; when '42'; then COSArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add '42'; when FALSE; then COSArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add '42'; when FALSE; then COSArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add '42'; when ONE; then COSArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add '42'; when ONE; then COSArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@link COSInteger#ONE}.
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add ONE; when ONE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@link COSInteger#THREE}.
   *   <li>Then {@link COSArrayList#COSArrayList()} first {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList() add THREE; then COSArrayList() first COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
  void testRemoveWithO_givenCOSArrayListAddThree_thenCOSArrayListFirstCOSInteger() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add(COSInteger.THREE);
    objectList.add("42");

    // Act
    boolean actualRemoveResult = objectList.remove(COSInteger.ONE);

    // Assert
    assertEquals(2, objectList.size());
    Object getResult = objectList.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertFalse(actualRemoveResult);
    assertSame(COSInteger.THREE, getResult);
  }

  /**
   * Test {@link COSArrayList#remove(Object)} with {@code o}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object) with 'o'; given COSArrayList(); when '42'; then COSArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.remove(Object)"})
  void testRemoveWithO_givenCOSArrayList_when42_thenCOSArrayListEmpty() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.remove("42"));
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link COSArrayList#indexOf(Object)}.
   *
   * <p>Method under test: {@link COSArrayList#indexOf(Object)}
   */
  @Test
  @DisplayName("Test indexOf(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArrayList.indexOf(Object)"})
  void testIndexOf() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(-1, objectList.indexOf("42"));
  }

  /**
   * Test {@link COSArrayList#lastIndexOf(Object)}.
   *
   * <p>Method under test: {@link COSArrayList#lastIndexOf(Object)}
   */
  @Test
  @DisplayName("Test lastIndexOf(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArrayList.lastIndexOf(Object)"})
  void testLastIndexOf() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertEquals(-1, objectList.lastIndexOf("42"));
  }

  /**
   * Test {@link COSArrayList#listIterator()}.
   *
   * <p>Method under test: {@link COSArrayList#listIterator()}
   */
  @Test
  @DisplayName("Test listIterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListIterator COSArrayList.listIterator()"})
  void testListIterator() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.listIterator().hasNext());
  }

  /**
   * Test {@link COSArrayList#listIterator(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#listIterator(int)}
   */
  @Test
  @DisplayName(
      "Test listIterator(int) with 'int'; given COSArrayList() add '42'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListIterator COSArrayList.listIterator(int)"})
  void testListIteratorWithInt_givenCOSArrayListAdd42_thenReturnNotHasNext() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertFalse(objectList.listIterator(1).hasNext());
  }

  /**
   * Test {@link COSArrayList#subList(int, int)}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#subList(int, int)}
   */
  @Test
  @DisplayName("Test subList(int, int); given COSArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArrayList.subList(int, int)"})
  void testSubList_givenCOSArrayListAdd42_thenReturnEmpty() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertTrue(objectList.subList(1, 1).isEmpty());
  }

  /**
   * Test {@link COSArrayList#containsAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test containsAll(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.containsAll(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test containsAll(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.containsAll(Collection)"})
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#containsAll(Collection)}
   */
  @Test
  @DisplayName("Test containsAll(Collection); when ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.containsAll(Collection)"})
  void testContainsAll_whenArrayList_thenReturnTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertTrue(objectList.containsAll(new ArrayList<>()));
  }

  /**
   * Test {@link COSArrayList#addAll(Collection)} with {@code c}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'c'; given '42'; when ArrayList() add '42'; then COSArrayList() first is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'c'; given '42'; when ArrayList() add '42'; then COSArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'c'; given COSArray(); then COSArrayList() first is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'c'; given COSDictionary(); then COSArrayList() first is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'c'; given FALSE; when ArrayList() add FALSE; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(Collection)"})
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'c'; when ArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(Collection)"})
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
   * Test {@link COSArrayList#addAll(int, Collection)} with {@code index}, {@code c}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(int, Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(int, Collection) with 'index', 'c'; given COSArrayList() add '42'; then COSArrayList() size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(int, Collection)"})
  void testAddAllWithIndexC_givenCOSArrayListAdd42_thenCOSArrayListSizeIsThree() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");
    c.add("42");

    // Act
    boolean actualAddAllResult = objectList.addAll(1, c);

    // Assert
    assertEquals(3, objectList.size());
    assertEquals("42", objectList.get(1));
    assertEquals("42", objectList.get(2));
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link COSArrayList#addAll(int, Collection)} with {@code index}, {@code c}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(int, Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(int, Collection) with 'index', 'c'; given COSArrayList() add '42'; then COSArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(int, Collection)"})
  void testAddAllWithIndexC_givenCOSArrayListAdd42_thenCOSArrayListSizeIsTwo() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    ArrayList<Object> c = new ArrayList<>();
    c.add("42");

    // Act
    boolean actualAddAllResult = objectList.addAll(1, c);

    // Assert
    assertEquals(2, objectList.size());
    assertEquals("42", objectList.get(1));
    assertTrue(actualAddAllResult);
  }

  /**
   * Test {@link COSArrayList#addAll(int, Collection)} with {@code index}, {@code c}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link COSArrayList#COSArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#addAll(int, Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(int, Collection) with 'index', 'c'; when ArrayList(); then COSArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.addAll(int, Collection)"})
  void testAddAllWithIndexC_whenArrayList_thenCOSArrayListSizeIsOne() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act
    boolean actualAddAllResult = objectList.addAll(1, new ArrayList<>());

    // Assert
    assertEquals(1, objectList.size());
    assertFalse(actualAddAllResult);
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return toList first toHexString is {@code 3432}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName(
      "Test converterToCOSArray(List); given '42'; then return toList first toHexString is '3432'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_given42_thenReturnToListFirstToHexStringIs3432() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add("42");
    cosObjectableList.add(2);

    // Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(cosObjectableList);

    // Assert
    List<? extends COSBase> toListResult = actualConverterToCOSArrayResult.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertArrayEquals(new byte[] {'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add((byte) 'A');
    cosObjectableList.add(2);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> COSArrayList.converterToCOSArray(cosObjectableList));
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then toList first return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName(
      "Test converterToCOSArray(List); given COSArray(); then toList first return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_givenCOSArray_thenToListFirstReturnCOSArray() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    COSArray cosArray = new COSArray();
    cosObjectableList.add(cosArray);
    cosObjectableList.add(2);

    // Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(cosObjectableList);

    // Assert
    List<? extends COSBase> toListResult = actualConverterToCOSArrayResult.toList();
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then toList first return {@link COSNull}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given 'null'; then toList first return COSNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_givenNull_thenToListFirstReturnCOSNull() {
    // Arrange
    ArrayList<?> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(null);

    // Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(cosObjectableList);

    // Assert
    List<? extends COSBase> toListResult = actualConverterToCOSArrayResult.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSNull);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then toList first return {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given ten; then toList first return COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_givenTen_thenToListFirstReturnCOSFloat() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(10.0d);
    cosObjectableList.add(2);

    // Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(cosObjectableList);

    // Assert
    List<? extends COSBase> toListResult = actualConverterToCOSArrayResult.toList();
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
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then toList first return {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given ten; then toList first return COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_givenTen_thenToListFirstReturnCOSFloat2() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(10.0f);
    cosObjectableList.add(2);

    // Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(cosObjectableList);

    // Assert
    List<? extends COSBase> toListResult = actualConverterToCOSArrayResult.toList();
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
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then toList first return {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); given two; then toList first return COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_givenTwo_thenToListFirstReturnCOSInteger() {
    // Arrange
    ArrayList<Object> cosObjectableList = new ArrayList<>();
    cosObjectableList.add(2);

    // Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(cosObjectableList);

    // Assert
    List<? extends COSBase> toListResult = actualConverterToCOSArrayResult.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); when ArrayList(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_whenArrayList_thenReturnToListEmpty() {
    // Arrange and Act
    COSArray actualConverterToCOSArrayResult = COSArrayList.converterToCOSArray(new ArrayList<>());

    // Assert
    assertTrue(actualConverterToCOSArrayResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>When {@link COSArrayList#COSArrayList()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); when COSArrayList(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_whenCOSArrayList_thenReturnToListEmpty() {
    // Arrange and Act
    COSArray actualConverterToCOSArrayResult =
        COSArrayList.converterToCOSArray(new COSArrayList<>());

    // Assert
    assertTrue(actualConverterToCOSArrayResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArrayList#converterToCOSArray(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#converterToCOSArray(List)}
   */
  @Test
  @DisplayName("Test converterToCOSArray(List); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.converterToCOSArray(List)"})
  void testConverterToCOSArray_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(COSArrayList.converterToCOSArray(null));
  }

  /**
   * Test {@link COSArrayList#removeAll(Collection)}.
   *
   * <p>Method under test: {@link COSArrayList#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.removeAll(Collection)"})
  void testRemoveAll() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertFalse(objectList.removeAll(new ArrayList<>()));
  }

  /**
   * Test {@link COSArrayList#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given COSArrayList() add '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.retainAll(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given COSArrayList(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.retainAll(Collection)"})
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
   * Test {@link COSArrayList#equals(Object)}, and {@link COSArrayList#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSArrayList#equals(Object)}
   *   <li>{@link COSArrayList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.equals(Object)", "int COSArrayList.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    COSArrayList<Object> objectList2 = new COSArrayList<>();

    // Act and Assert
    assertEquals(objectList, objectList2);
    assertEquals(objectList.hashCode(), objectList2.hashCode());
  }

  /**
   * Test {@link COSArrayList#equals(Object)}, and {@link COSArrayList#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSArrayList#equals(Object)}
   *   <li>{@link COSArrayList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.equals(Object)", "int COSArrayList.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.equals(Object)", "int COSArrayList.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    // Act and Assert
    assertNotEquals(objectList, new COSArrayList<>());
  }

  /**
   * Test {@link COSArrayList#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.equals(Object)", "int COSArrayList.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertNotEquals(objectList, null);
  }

  /**
   * Test {@link COSArrayList#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArrayList.equals(Object)", "int COSArrayList.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();

    // Act and Assert
    assertNotEquals(objectList, "Different type to COSArrayList");
  }

  /**
   * Test {@link COSArrayList#get(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArrayList#COSArrayList()} add {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#get(int)}
   */
  @Test
  @DisplayName("Test get(int); given COSArrayList() add '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object COSArrayList.get(int)"})
  void testGet_givenCOSArrayListAdd42_thenReturn42() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    objectList.add("42");

    // Act and Assert
    assertEquals("42", objectList.get(1));
  }

  /**
   * Test {@link COSArrayList#set(int, Object)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#set(int, Object)}
   */
  @Test
  @DisplayName("Test set(int, Object); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object COSArrayList.set(int, Object)"})
  void testSet_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Act
    Object actualSetResult = objectList.set(0, pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", actualSetResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#set(int, Object)}.
   *
   * <ul>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@link
   *       PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#set(int, Object)}
   */
  @Test
  @DisplayName(
      "Test set(int, Object); then COSArrayList() first is PDDestinationNameTreeNode(COSDictionary) with dic is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object COSArrayList.set(int, Object)"})
  void testSet_thenCOSArrayListFirstIsPDDestinationNameTreeNodeWithDicIsCOSDictionary() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    PDDestinationNameTreeNode pdDestinationNameTreeNode =
        new PDDestinationNameTreeNode(new COSDictionary());

    // Act
    Object actualSetResult = objectList.set(0, pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", actualSetResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#set(int, Object)}.
   *
   * <ul>
   *   <li>Then {@link COSArrayList#COSArrayList()} first is {@link
   *       PDDestinationNameTreeNode#PDDestinationNameTreeNode(COSDictionary)} with dic is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#set(int, Object)}
   */
  @Test
  @DisplayName(
      "Test set(int, Object); then COSArrayList() first is PDDestinationNameTreeNode(COSDictionary) with dic is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object COSArrayList.set(int, Object)"})
  void testSet_thenCOSArrayListFirstIsPDDestinationNameTreeNodeWithDicIsNull() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(null);

    // Act
    Object actualSetResult = objectList.set(0, pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", actualSetResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test {@link COSArrayList#set(int, Object)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArrayList#set(int, Object)}
   */
  @Test
  @DisplayName(
      "Test set(int, Object); when COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object COSArrayList.set(int, Object)"})
  void testSet_whenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArrayList<Object> objectList = new COSArrayList<>();
    objectList.add("42");

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDDestinationNameTreeNode pdDestinationNameTreeNode = new PDDestinationNameTreeNode(dic);

    // Act
    Object actualSetResult = objectList.set(0, pdDestinationNameTreeNode);

    // Assert
    assertEquals(1, objectList.size());
    assertEquals("42", actualSetResult);
    assertSame(pdDestinationNameTreeNode, objectList.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSArrayList#toString()}
   *   <li>{@link COSArrayList#toList()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArrayList.toList()", "String COSArrayList.toString()"})
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
