package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDestinationNameTreeNode;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSArrayDiffblueTest {
  /**
   * Test {@link COSArray#of(float[])}.
   *
   * <p>Method under test: {@link COSArray#of(float[])}
   */
  @Test
  @DisplayName("Test of(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.of(float[])"})
  void testOf() {
    // Arrange and Act
    COSArray actualOfResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Assert
    List<? extends COSBase> toListResult = actualOfResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
  }

  /**
   * Test {@link COSArray#COSArray()}.
   *
   * <p>Method under test: {@link COSArray#COSArray()}
   */
  @Test
  @DisplayName("Test new COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.<init>()"})
  void testNewCOSArray() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().toList().isEmpty());
  }

  /**
   * Test {@link COSArray#COSArray(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return toList is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#COSArray(List)}
   */
  @Test
  @DisplayName(
      "Test new COSArray(List); given 'null'; when ArrayList() add 'null'; then return toList is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.<init>(List)"})
  void testNewCOSArray_givenNull_whenArrayListAddNull_thenReturnToListIsArrayList() {
    // Arrange
    ArrayList<? extends COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(null);

    // Act and Assert
    assertEquals(cosObjectables, new COSArray(cosObjectables).toList());
  }

  /**
   * Test {@link COSArray#COSArray(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#COSArray(List)}
   */
  @Test
  @DisplayName("Test new COSArray(List); when ArrayList(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.<init>(List)"})
  void testNewCOSArray_whenArrayList_thenReturnToListEmpty() {
    // Arrange, Act and Assert
    assertTrue(new COSArray(new ArrayList<>()).toList().isEmpty());
  }

  /**
   * Test {@link COSArray#add(COSBase)} with {@code COSBase}.
   *
   * <p>Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  @DisplayName("Test add(COSBase) with 'COSBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSBase)"})
  void testAddWithCOSBase() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosArray.add((COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(object, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#add(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  @DisplayName("Test add(COSBase) with 'COSBase'; then COSArray() toList first COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSBase)"})
  void testAddWithCOSBase_thenCOSArrayToListFirstCOSObject() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSDictionary object = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    object.setKey(key);

    // Act
    cosArray.add((COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(object, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link COSArray#add(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  @DisplayName("Test add(COSBase) with 'COSBase'; when COSArray(); then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSBase)"})
  void testAddWithCOSBase_whenCOSArray_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSArray object = new COSArray();

    // Act
    cosArray.add((COSBase) object);

    // Assert that nothing has changed
    assertTrue(object.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#add(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  @DisplayName(
      "Test add(COSBase) with 'COSBase'; when COSDictionary(); then COSArray() toList first is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSBase)"})
  void testAddWithCOSBase_whenCOSDictionary_thenCOSArrayToListFirstIsCOSDictionary() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSDictionary object = new COSDictionary();

    // Act
    cosArray.add((COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(object, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#add(COSBase)} with {@code COSBase}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  @DisplayName(
      "Test add(COSBase) with 'COSBase'; when FALSE; then COSArray() toList first is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSBase)"})
  void testAddWithCOSBase_whenFalse_thenCOSArrayToListFirstIsFalse() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.add(COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(COSBoolean.FALSE, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#add(COSObjectable)} with {@code COSObjectable}.
   *
   * <p>Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  @DisplayName("Test add(COSObjectable) with 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSObjectable)"})
  void testAddWithCOSObjectable() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    dic.setKey(null);

    // Act
    cosArray.add(new PDDestinationNameTreeNode(dic));

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(dic, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#add(COSObjectable)} with {@code COSObjectable}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} Direct is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  @DisplayName("Test add(COSObjectable) with 'COSObjectable'; given COSArray() Direct is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSObjectable)"})
  void testAddWithCOSObjectable_givenCOSArrayDirectIsFalse() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSArray cosArray2 = new COSArray();
    cosArray2.setDirect(false);
    cosArray2.setKey(null);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosArray2);

    // Act
    cosArray.add(object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(cosArray2, getResult);
  }

  /**
   * Test {@link COSArray#add(COSObjectable)} with {@code COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test add(COSObjectable) with 'COSObjectable'; then COSArray() toList first COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSObjectable)"})
  void testAddWithCOSObjectable_thenCOSArrayToListFirstCOSArray() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSObjectable object = mock(COSObjectable.class);
    COSArray cosArray2 = new COSArray();
    when(object.getCOSObject()).thenReturn(cosArray2);

    // Act
    cosArray.add(object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(cosArray2, getResult);
  }

  /**
   * Test {@link COSArray#add(COSObjectable)} with {@code COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test add(COSObjectable) with 'COSObjectable'; then COSArray() toList first COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSObjectable)"})
  void testAddWithCOSObjectable_thenCOSArrayToListFirstCOSObject() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSDictionary dic = new COSDictionary(new COSDictionary());
    dic.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    dic.setKey(key);

    // Act
    cosArray.add(new PDDestinationNameTreeNode(dic));

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(dic, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link COSArray#add(COSObjectable)} with {@code COSObjectable}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test add(COSObjectable) with 'COSObjectable'; when FALSE; then COSArray() toList first is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSObjectable)"})
  void testAddWithCOSObjectable_whenFalse_thenCOSArrayToListFirstIsFalse() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.add((COSObjectable) COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(COSBoolean.FALSE, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#add(COSObjectable)} with {@code COSObjectable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSArray#COSArray()} toList first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test add(COSObjectable) with 'COSObjectable'; when 'null'; then COSArray() toList first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(COSObjectable)"})
  void testAddWithCOSObjectable_whenNull_thenCOSArrayToListFirstIsNull() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.add((COSObjectable) null);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertNull(toListResult.get(0));
  }

  /**
   * Test {@link COSArray#add(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <p>Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  @DisplayName("Test add(int, COSBase) with 'int', 'COSBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(int, COSBase)"})
  void testAddWithIntCOSBase() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    ofResult.add(2, object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(object, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#add(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList third {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test add(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList third COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(int, COSBase)"})
  void testAddWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListThirdCOSObject() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSDictionary object = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    object.setKey(key);

    // Act
    ofResult.add(2, object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(object, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link COSArray#add(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList third is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test add(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList third is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(int, COSBase)"})
  void testAddWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListThirdIsCOSArray() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSArray object = new COSArray();

    // Act
    ofResult.add(2, object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(object, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#add(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList third is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test add(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList third is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(int, COSBase)"})
  void testAddWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListThirdIsCOSDictionary() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSDictionary object = new COSDictionary();

    // Act
    ofResult.add(2, object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(object, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#add(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList third is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test add(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList third is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.add(int, COSBase)"})
  void testAddWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListThirdIsFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.add(2, COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(COSBoolean.FALSE, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given A; when ArrayList() add A; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenA_whenArrayListAddA_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.A);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSName#AA}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#AA}.
   *   <li>Then {@link COSArray#COSArray()} toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given AA; when ArrayList() add AA; then COSArray() toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenAa_whenArrayListAddAa_thenCOSArrayToListSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.AA);

    // Act
    cosArray.removeAll(objectsList);

    // Assert that nothing has changed
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then {@link COSArray#COSArray()} toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given COSArray() add A; then COSArray() toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArrayAddA_thenCOSArrayToListSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert that nothing has changed
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given COSArray() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArrayAddFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then {@link COSArray#COSArray()} toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given COSArray() add ONE; then COSArray() toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArrayAddOne_thenCOSArrayToListSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert that nothing has changed
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection); given COSArray with floats is ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} add {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection); given COSArray with floats is ten and '0.5' add A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArrayWithFloatsIsTenAnd05AddA() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection); given COSArray with floats is ten and '0.5' add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArrayWithFloatsIsTenAnd05AddFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSBoolean.FALSE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given COSArray(); when ArrayList() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArray_whenArrayListAddFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given COSArray(); when ArrayList() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArray_whenArrayListAddFalse_thenCOSArrayToListEmpty2() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given COSArray(); when ArrayList(); then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenCOSArray_whenArrayList_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.removeAll(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); given forty-two; then COSArray with floats is ten and '0.5' toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenFortyTwo_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsThree() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.get(42L));

    // Act
    ofResult.removeAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection); given ONE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenOne_whenArrayListAddOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSFloat.ONE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName("Test removeAll(Collection); given ONE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_givenOne_whenArrayListAddOne2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.ONE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link
   *       COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); then COSArray with floats is ten and '0.5' toList second COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSInteger() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is five.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); then COSArray with floats is ten and '0.5' toList size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFive() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSBoolean.FALSE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSFloat.ONE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link COSArray#removeAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test removeAll(Collection); then COSArray with floats is ten and '0.5' toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.removeAll(Collection)"})
  void testRemoveAll_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(new COSFloat(10.0f));

    // Act
    ofResult.removeAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then {@link COSArray#COSArray()} toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given A; when ArrayList() add A; then COSArray() toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenA_whenArrayListAddA_thenCOSArrayToListSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.A);

    // Act
    cosArray.retainAll(objectsList);

    // Assert that nothing has changed
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSName#AA}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#AA}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given AA; when ArrayList() add AA; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenAa_whenArrayListAddAa_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.AA);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray() add A; when ArrayList() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayAddA_whenArrayListAddFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray() add FALSE; then COSArray() toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayAddFalse_thenCOSArrayToListSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert that nothing has changed
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray() add ONE; when ArrayList() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayAddOne_whenArrayListAddFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given COSArray with floats is ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} add {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given COSArray with floats is ten and '0.5' add A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayWithFloatsIsTenAnd05AddA() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSName.A);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} add {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray with floats is ten and '0.5' add FALSE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayWithFloatsIsTenAnd05AddFalse_whenArrayListAddOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSBoolean.FALSE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSFloat.ONE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} one is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray with floats is ten and '0.5' one is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayWithFloatsIsTenAnd05OneIsFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray with floats is ten and '0.5'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArrayWithFloatsIsTenAnd05_whenArrayList() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.retainAll(new ArrayList<>());

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray(); when ArrayList() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArray_whenArrayListAddFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray(); when ArrayList() add FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArray_whenArrayListAddFalse_thenCOSArrayToListEmpty2() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); given COSArray(); when ArrayList(); then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenCOSArray_whenArrayList_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.retainAll(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given ONE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenOne_whenArrayListAddOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSFloat.ONE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName("Test retainAll(Collection); given ONE; when ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_givenOne_whenArrayListAddOne2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.ONE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList first is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); then COSArray with floats is ten and '0.5' toList first is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_thenCOSArrayWithFloatsIsTenAnd05ToListFirstIsFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSInteger getResult = COSInteger.get(42L);
    objectsList.add(getResult);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(1, toListResult.size());
    assertSame(getResult, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); then COSArray with floats is ten and '0.5' toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSBoolean.FALSE);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    assertEquals(1, ofResult.toList().size());
  }

  /**
   * Test {@link COSArray#retainAll(Collection)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test retainAll(Collection); then COSArray with floats is ten and '0.5' toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.retainAll(Collection)"})
  void testRetainAll_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(new COSFloat(10.0f));

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Test {@link COSArray#addAll(int, Collection)} with {@code i}, {@code objectList}.
   *
   * <p>Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  @DisplayName("Test addAll(int, Collection) with 'i', 'objectList'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(int, Collection)"})
  void testAddAllWithIObjectList() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectList = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    objectList.add(cosDictionary);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(cosDictionary, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#addAll(int, Collection)} with {@code i}, {@code objectList}.
   *
   * <p>Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  @DisplayName("Test addAll(int, Collection) with 'i', 'objectList'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(int, Collection)"})
  void testAddAllWithIObjectList2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectList = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    objectList.add(cosObject);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(cosObject, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#addAll(int, Collection)} with {@code i}, {@code objectList}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(int, Collection) with 'i', 'objectList'; given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(int, Collection)"})
  void testAddAllWithIObjectList_givenFalse_whenArrayListAddFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectList = new ArrayList<>();
    objectList.add(COSBoolean.FALSE);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
  }

  /**
   * Test {@link COSArray#addAll(int, Collection)} with {@code i}, {@code objectList}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(int, Collection) with 'i', 'objectList'; then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(int, Collection)"})
  void testAddAllWithIObjectList_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.addAll(2, new ArrayList<>());

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
  }

  /**
   * Test {@link COSArray#addAll(int, Collection)} with {@code i}, {@code objectList}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList third is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(int, Collection) with 'i', 'objectList'; then COSArray with floats is ten and '0.5' toList third is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(int, Collection)"})
  void testAddAllWithIObjectList_thenCOSArrayWithFloatsIsTenAnd05ToListThirdIsCOSArray() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    ArrayList<COSBase> objectList = new ArrayList<>();
    COSArray cosArray = new COSArray();
    objectList.add(cosArray);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(toListResult.get(0), getResult);
    assertEquals(toListResult.get(1), getResult2);
    assertSame(cosArray, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#addAll(COSArray)} with {@code objectList}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(COSArray)}
   */
  @Test
  @DisplayName(
      "Test addAll(COSArray) with 'objectList'; when COSArray(); then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(COSArray)"})
  void testAddAllWithObjectList_whenCOSArray_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSArray objectList = new COSArray();

    // Act
    cosArray.addAll(objectList);

    // Assert that nothing has changed
    assertTrue(objectList.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#addAll(COSArray)} with {@code objectList}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(COSArray)}
   */
  @Test
  @DisplayName("Test addAll(COSArray) with 'objectList'; when 'null'; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(COSArray)"})
  void testAddAllWithObjectList_whenNull_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.addAll((COSArray) null);

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#addAll(Collection)} with {@code objectsList}.
   *
   * <p>Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  @DisplayName("Test addAll(Collection) with 'objectsList'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(Collection)"})
  void testAddAllWithObjectsList() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    objectsList.add(cosObject);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(cosObject, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#addAll(Collection)} with {@code objectsList}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'objectsList'; given FALSE; then COSArray() toList is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(Collection)"})
  void testAddAllWithObjectsList_givenFalse_thenCOSArrayToListIsArrayList() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    assertEquals(objectsList, cosArray.toList());
  }

  /**
   * Test {@link COSArray#addAll(Collection)} with {@code objectsList}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'objectsList'; given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(Collection)"})
  void testAddAllWithObjectsList_givenFalse_whenArrayListAddFalse() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Test {@link COSArray#addAll(Collection)} with {@code objectsList}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'objectsList'; then COSArray() toList first is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(Collection)"})
  void testAddAllWithObjectsList_thenCOSArrayToListFirstIsCOSArray() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSArray cosArray2 = new COSArray();
    objectsList.add(cosArray2);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(cosArray2, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#addAll(Collection)} with {@code objectsList}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'objectsList'; then COSArray() toList first is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(Collection)"})
  void testAddAllWithObjectsList_thenCOSArrayToListFirstIsCOSDictionary() {
    // Arrange
    COSArray cosArray = new COSArray();

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    objectsList.add(cosDictionary);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(cosDictionary, toListResult.get(0));
  }

  /**
   * Test {@link COSArray#addAll(Collection)} with {@code objectsList}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  @DisplayName(
      "Test addAll(Collection) with 'objectsList'; when ArrayList(); then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.addAll(Collection)"})
  void testAddAllWithObjectsList_whenArrayList_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.addAll(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#set(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <p>Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  @DisplayName("Test set(int, COSBase) with 'int', 'COSBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSBase)"})
  void testSetWithIntCOSBase() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSDictionary object = new COSDictionary();

    // Act
    ofResult.set(1, (COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(object, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <p>Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  @DisplayName("Test set(int, COSBase) with 'int', 'COSBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSBase)"})
  void testSetWithIntCOSBase2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    ofResult.set(1, (COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(object, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList second COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSBase)"})
  void testSetWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSObject() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSDictionary object = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    object.setKey(key);

    // Act
    ofResult.set(1, (COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(object, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link COSArray#set(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second is {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList second is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSBase)"})
  void testSetWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListSecondIsCOSArray() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSArray object = new COSArray();

    // Act
    ofResult.set(1, (COSBase) object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(object, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSBase)} with {@code int}, {@code COSBase}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSBase) with 'int', 'COSBase'; then COSArray with floats is ten and '0.5' toList second is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSBase)"})
  void testSetWithIntCOSBase_thenCOSArrayWithFloatsIsTenAnd05ToListSecondIsFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.set(1, COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName("Test set(int, COSObjectable) with 'int', 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(null);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosBoolean);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSBoolean);
    assertNull(getResult.getKey());
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName("Test set(int, COSObjectable) with 'int', 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(false);
    cosDictionary.setKey(null);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosDictionary);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(cosDictionary, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName("Test set(int, COSObjectable) with 'int', 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable3() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosObject.setDirect(false);
    cosObject.setKey(null);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosObject);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(cosObject, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName("Test set(int, COSObjectable) with 'int', 'COSObjectable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable4() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSArray cosArray = new COSArray();
    cosArray.setDirect(false);
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosArray.setKey(key);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosArray);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSArray);
    assertTrue(getResult instanceof COSObject);
    assertTrue(((COSArray) object2).toList().isEmpty());
    assertSame(cosArray, object2);
    assertSame(key, getResult.getKey());
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSObjectable) with 'int', 'COSObjectable'; then COSArray with floats is ten and '0.5' toList second COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSArray() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSArray cosArray = new COSArray();
    cosArray.setDirect(false);
    cosArray.setKey(null);

    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosArray);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(cosArray, getResult);
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSObjectable) with 'int', 'COSObjectable'; then COSArray with floats is ten and '0.5' toList second COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSArray2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSObjectable object = mock(COSObjectable.class);
    COSArray cosArray = new COSArray();
    when(object.getCOSObject()).thenReturn(cosArray);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSArray);
    assertTrue(((COSArray) getResult).toList().isEmpty());
    assertSame(cosArray, getResult);
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSObjectable) with 'int', 'COSObjectable'; then COSArray with floats is ten and '0.5' toList second is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable_thenCOSArrayWithFloatsIsTenAnd05ToListSecondIsFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.set(1, (COSObjectable) COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(COSBoolean.FALSE, toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, COSObjectable)} with {@code int}, {@code COSObjectable}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  @DisplayName(
      "Test set(int, COSObjectable) with 'int', 'COSObjectable'; then COSArray with floats is ten and '0.5' toList second is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, COSObjectable)"})
  void testSetWithIntCOSObjectable_thenCOSArrayWithFloatsIsTenAnd05ToListSecondIsNull() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.set(1, (COSObjectable) null);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(1));
  }

  /**
   * Test {@link COSArray#set(int, int)} with {@code int}, {@code int}.
   *
   * <ul>
   *   <li>Then not {@link COSArray} with floats is ten and {@code 0.5} toList second Direct.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#set(int, int)}
   */
  @Test
  @DisplayName(
      "Test set(int, int) with 'int', 'int'; then not COSArray with floats is ten and '0.5' toList second Direct")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.set(int, int)"})
  void testSetWithIntInt_thenNotCOSArrayWithFloatsIsTenAnd05ToListSecondDirect() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.set(1, Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArray#getObject(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getObject(int)}
   */
  @Test
  @DisplayName(
      "Test getObject(int); given COSArray with floats is ten and '0.5'; then return COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSArray.getObject(int)"})
  void testGetObject_givenCOSArrayWithFloatsIsTenAnd05_thenReturnCOSFloat() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    COSBase actualObject = ofResult.getObject(1);

    // Assert
    assertTrue(actualObject instanceof COSFloat);
    assertNull(actualObject.getKey());
    assertFalse(actualObject.isDirect());
  }

  /**
   * Test {@link COSArray#get(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return {@link COSFloat}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#get(int)}
   */
  @Test
  @DisplayName("Test get(int); given COSArray with floats is ten and '0.5'; then return COSFloat")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSArray.get(int)"})
  void testGet_givenCOSArrayWithFloatsIsTenAnd05_thenReturnCOSFloat() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    COSBase actualGetResult = ofResult.get(1);

    // Assert
    assertTrue(actualGetResult instanceof COSFloat);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} one is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray with floats is ten and '0.5' one is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArrayWithFloatsIsTenAnd05OneIsFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, COSBoolean.FALSE);

    // Act and Assert
    assertEquals(42, ofResult.getInt(1, 42));
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} one is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray with floats is ten and '0.5' one is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArrayWithFloatsIsTenAnd05OneIsFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act and Assert
    assertEquals(42, ofResult.getInt(1, 42));
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray with floats is ten and '0.5'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArrayWithFloatsIsTenAnd05_thenReturnZero() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertEquals(0, ofResult.getInt(1, 42));
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray(); when one; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArray_whenOne_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new COSArray().getInt(1, 42));
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray(); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArray_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new COSArray().getInt(1, 1));
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When three.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray(); when three; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArray_whenThree_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new COSArray().getInt(3, 42));
  }

  /**
   * Test {@link COSArray#getInt(int, int)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When zero.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int, int) with 'index', 'defaultValue'; given COSArray(); when zero; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int, int)"})
  void testGetIntWithIndexDefaultValue_givenCOSArray_whenZero_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new COSArray().getInt(0, 42));
  }

  /**
   * Test {@link COSArray#getInt(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} one is {@link
   *       COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int) with 'index'; given COSArray with floats is ten and '0.5' one is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int)"})
  void testGetIntWithIndex_givenCOSArrayWithFloatsIsTenAnd05OneIsFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, COSBoolean.FALSE);

    // Act and Assert
    assertEquals(-1, ofResult.getInt(1));
  }

  /**
   * Test {@link COSArray#getInt(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  @DisplayName(
      "Test getInt(int) with 'index'; given COSArray with floats is ten and '0.5'; when one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int)"})
  void testGetIntWithIndex_givenCOSArrayWithFloatsIsTenAnd05_whenOne_thenReturnZero() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertEquals(0, ofResult.getInt(1));
  }

  /**
   * Test {@link COSArray#getInt(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  @DisplayName("Test getInt(int) with 'index'; given COSArray(); when one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int)"})
  void testGetIntWithIndex_givenCOSArray_whenOne_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSArray().getInt(1));
  }

  /**
   * Test {@link COSArray#getInt(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  @DisplayName("Test getInt(int) with 'index'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.getInt(int)"})
  void testGetIntWithIndex_thenReturnFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act and Assert
    assertEquals(42, ofResult.getInt(1));
  }

  /**
   * Test {@link COSArray#setInt(int, int)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#setInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(int, int); then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setInt(int, int)"})
  void testSetInt_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.setInt(1, 42);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArray#setInt(int, int)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#setInt(int, int)}
   */
  @Test
  @DisplayName(
      "Test setInt(int, int); then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setInt(int, int)"})
  void testSetInt_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.setInt(1, Integer.MIN_VALUE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArray#setName(int, String)}.
   *
   * <p>Method under test: {@link COSArray#setName(int, String)}
   */
  @Test
  @DisplayName("Test setName(int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setName(int, String)"})
  void testSetName() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.setName(1, "org.apache.pdfbox.cos.COSNumber");

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("org.apache.pdfbox.cos.COSNumber", ((COSName) getResult).getName());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link COSArray#setName(int, String)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second Name is {@code
   *       Name}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#setName(int, String)}
   */
  @Test
  @DisplayName(
      "Test setName(int, String); then COSArray with floats is ten and '0.5' toList second Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setName(int, String)"})
  void testSetName_thenCOSArrayWithFloatsIsTenAnd05ToListSecondNameIsName() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.setName(1, "Name");

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSName);
    assertEquals("Name", ((COSName) getResult).getName());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link COSArray#getName(int, String)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getName(int, String)}
   */
  @Test
  @DisplayName(
      "Test getName(int, String) with 'index', 'defaultValue'; given COSArray with floats is ten and '0.5'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getName(int, String)"})
  void testGetNameWithIndexDefaultValue_givenCOSArrayWithFloatsIsTenAnd05_thenReturn42() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertEquals("42", ofResult.getName(1, "42"));
  }

  /**
   * Test {@link COSArray#getName(int, String)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getName(int, String)}
   */
  @Test
  @DisplayName(
      "Test getName(int, String) with 'index', 'defaultValue'; given COSArray(); when one; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getName(int, String)"})
  void testGetNameWithIndexDefaultValue_givenCOSArray_whenOne_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new COSArray().getName(1, "42"));
  }

  /**
   * Test {@link COSArray#getName(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getName(int)}
   */
  @Test
  @DisplayName(
      "Test getName(int) with 'index'; given COSArray with floats is ten and '0.5'; when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getName(int)"})
  void testGetNameWithIndex_givenCOSArrayWithFloatsIsTenAnd05_whenOne_thenReturnNull() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertNull(ofResult.getName(1));
  }

  /**
   * Test {@link COSArray#getName(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getName(int)}
   */
  @Test
  @DisplayName("Test getName(int) with 'index'; given COSArray(); when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getName(int)"})
  void testGetNameWithIndex_givenCOSArray_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSArray().getName(1));
  }

  /**
   * Test {@link COSArray#setString(int, String)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#setString(int, String)}
   */
  @Test
  @DisplayName(
      "Test setString(int, String); then COSArray with floats is ten and '0.5' toList second COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setString(int, String)"})
  void testSetString_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSString()
      throws UnsupportedEncodingException {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.setString(1, "String");

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSString);
    assertEquals("537472696E67", ((COSString) getResult).toHexString());
    assertEquals("String", ((COSString) getResult).getASCII());
    assertEquals("String", ((COSString) getResult).getString());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertArrayEquals("String".getBytes("UTF-8"), ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSArray#setString(int, String)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#setString(int, String)}
   */
  @Test
  @DisplayName(
      "Test setString(int, String); then COSArray with floats is ten and '0.5' toList second is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setString(int, String)"})
  void testSetString_thenCOSArrayWithFloatsIsTenAnd05ToListSecondIsNull() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.setString(1, null);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertNull(toListResult.get(1));
  }

  /**
   * Test {@link COSArray#getString(int, String)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getString(int, String)}
   */
  @Test
  @DisplayName(
      "Test getString(int, String) with 'index', 'defaultValue'; given COSArray with floats is ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getString(int, String)"})
  void testGetStringWithIndexDefaultValue_givenCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertEquals("42", ofResult.getString(1, "42"));
  }

  /**
   * Test {@link COSArray#getString(int, String)} with {@code index}, {@code defaultValue}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getString(int, String)}
   */
  @Test
  @DisplayName(
      "Test getString(int, String) with 'index', 'defaultValue'; given COSArray(); when one; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getString(int, String)"})
  void testGetStringWithIndexDefaultValue_givenCOSArray_whenOne_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new COSArray().getString(1, "42"));
  }

  /**
   * Test {@link COSArray#getString(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getString(int)}
   */
  @Test
  @DisplayName(
      "Test getString(int) with 'index'; given COSArray with floats is ten and '0.5'; when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getString(int)"})
  void testGetStringWithIndex_givenCOSArrayWithFloatsIsTenAnd05_whenOne_thenReturnNull() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertNull(ofResult.getString(1));
  }

  /**
   * Test {@link COSArray#getString(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getString(int)}
   */
  @Test
  @DisplayName("Test getString(int) with 'index'; given COSArray(); when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String COSArray.getString(int)"})
  void testGetStringWithIndex_givenCOSArray_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSArray().getString(1));
  }

  /**
   * Test {@link COSArray#size()}.
   *
   * <p>Method under test: {@link COSArray#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new COSArray().size());
  }

  /**
   * Test {@link COSArray#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given COSArray with floats is ten and '0.5'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.isEmpty()"})
  void testIsEmpty_givenCOSArrayWithFloatsIsTenAnd05_thenReturnFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertFalse(ofResult.isEmpty());
  }

  /**
   * Test {@link COSArray#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given COSArray(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.isEmpty()"})
  void testIsEmpty_givenCOSArray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().isEmpty());
  }

  /**
   * Test {@link COSArray#remove(int)} with {@code i}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int) with 'i'; then COSArray with floats is ten and '0.5' toList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSArray.remove(int)"})
  void testRemoveWithI_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsThree() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    COSBase actualRemoveResult = ofResult.remove(1);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(actualRemoveResult instanceof COSFloat);
    assertNull(actualRemoveResult.getKey());
    assertFalse(actualRemoveResult.isDirect());
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName("Test remove(COSBase) with 'o'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSFloat o = new COSFloat(10.0f);

    // Act
    ofResult.remove(o);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(o, getResult);
    assertEquals(toListResult.get(0), getResult2);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName("Test remove(COSBase) with 'o'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSInteger.get(42L));

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; given COSArray() add FALSE; when FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_givenCOSArrayAddFalse_whenFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveResult = cosArray.remove(COSBoolean.FALSE);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; given COSArray(); when FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_givenCOSArray_whenFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act and Assert
    assertFalse(cosArray.remove(COSBoolean.FALSE));
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link
   *       COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; then COSArray with floats is ten and '0.5' toList second COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSInteger() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSInteger.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertFalse(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is five.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; then COSArray with floats is ten and '0.5' toList size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFive() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; when A; then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_whenA_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSName.A);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; when FALSE; then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_whenFalse_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>When {@link COSFloat#ONE}.
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; when ONE; then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_whenOne_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#remove(COSBase)} with {@code o}.
   *
   * <ul>
   *   <li>When {@link COSInteger#ONE}.
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  @DisplayName(
      "Test remove(COSBase) with 'o'; when ONE; then COSArray with floats is ten and '0.5' toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.remove(COSBase)"})
  void testRemoveWithO_whenOne_thenCOSArrayWithFloatsIsTenAnd05ToListSizeIsFour2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSInteger.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSFloat o = new COSFloat(10.0f);

    // Act
    ofResult.removeObject(o);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(o, getResult);
    assertEquals(toListResult.get(0), getResult2);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSInteger.get(42L));

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject3() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    ofResult.add((COSBase) object);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject4() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObject object = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));
    ofResult.add((COSBase) object);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject5() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObject object = new COSObject(COSInteger.ONE, new COSObjectKey(1L, 1));
    ofResult.add((COSBase) object);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject6() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSArray object = new COSArray();
    COSObject object2 = new COSObject(object, new COSObjectKey(1L, 1));
    ofResult.add((COSBase) object2);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject7() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObject object = new COSObject(COSName.A, new COSObjectKey(1L, 1));
    ofResult.add((COSBase) object);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeObject(COSBase); given COSArray() add FALSE; when FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArrayAddFalse_whenFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectResult = cosArray.removeObject(COSBoolean.FALSE);

    // Assert
    assertTrue(cosArray.toList().isEmpty());
    assertTrue(actualRemoveObjectResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase); given COSArray with floats is ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase); given COSArray with floats is ten and '0.5' add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArrayWithFloatsIsTenAnd05AddFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase); given COSArray with floats is ten and '0.5'; when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArrayWithFloatsIsTenAnd05_whenA() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSName.A);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeObject(COSBase); given COSArray with floats is ten and '0.5'; when FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArrayWithFloatsIsTenAnd05_whenFalse() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>When {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName("Test removeObject(COSBase); given COSArray with floats is ten and '0.5'; when ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArrayWithFloatsIsTenAnd05_whenOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSInteger.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeObject(COSBase); given COSArray(); when FALSE; then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_givenCOSArray_whenFalse_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act and Assert
    assertFalse(cosArray.removeObject(COSBoolean.FALSE));
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#removeObject(COSBase)}.
   *
   * <ul>
   *   <li>Then {@link COSArray} with floats is ten and {@code 0.5} toList second {@link
   *       COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test removeObject(COSBase); then COSArray with floats is ten and '0.5' toList second COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSArray.removeObject(COSBase)"})
  void testRemoveObject_thenCOSArrayWithFloatsIsTenAnd05ToListSecondCOSInteger() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSInteger.ONE);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertFalse(actualRemoveObjectResult);
    assertEquals(toListResult.get(0), getResult);
  }

  /**
   * Test {@link COSArray#iterator()}.
   *
   * <p>Method under test: {@link COSArray#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator COSArray.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new COSArray().iterator().hasNext());
  }

  /**
   * Test {@link COSArray#indexOf(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#indexOf(COSBase)}
   */
  @Test
  @DisplayName("Test indexOf(COSBase); given COSArray() add FALSE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.indexOf(COSBase)"})
  void testIndexOf_givenCOSArrayAddFalse_thenReturnZero() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertEquals(0, cosArray.indexOf(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSArray#indexOf(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#indexOf(COSBase)}
   */
  @Test
  @DisplayName(
      "Test indexOf(COSBase); given COSArray with floats is ten and '0.5'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.indexOf(COSBase)"})
  void testIndexOf_givenCOSArrayWithFloatsIsTenAnd05_thenReturnMinusOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertEquals(-1, ofResult.indexOf(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSArray#indexOf(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#indexOf(COSBase)}
   */
  @Test
  @DisplayName("Test indexOf(COSBase); given COSArray(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.indexOf(COSBase)"})
  void testIndexOf_givenCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSArray().indexOf(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSArray#indexOfObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#indexOfObject(COSBase)}
   */
  @Test
  @DisplayName("Test indexOfObject(COSBase); given COSArray() add FALSE; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.indexOfObject(COSBase)"})
  void testIndexOfObject_givenCOSArrayAddFalse_thenReturnZero() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertEquals(0, cosArray.indexOfObject(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSArray#indexOfObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} with floats is ten and {@code 0.5}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#indexOfObject(COSBase)}
   */
  @Test
  @DisplayName(
      "Test indexOfObject(COSBase); given COSArray with floats is ten and '0.5'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.indexOfObject(COSBase)"})
  void testIndexOfObject_givenCOSArrayWithFloatsIsTenAnd05_thenReturnMinusOne() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertEquals(-1, ofResult.indexOfObject(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSArray#indexOfObject(COSBase)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#indexOfObject(COSBase)}
   */
  @Test
  @DisplayName("Test indexOfObject(COSBase); given COSArray(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int COSArray.indexOfObject(COSBase)"})
  void testIndexOfObject_givenCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new COSArray().indexOfObject(COSBoolean.FALSE));
  }

  /**
   * Test {@link COSArray#growToSize(int)} with {@code size}.
   *
   * <p>Method under test: {@link COSArray#growToSize(int)}
   */
  @Test
  @DisplayName("Test growToSize(int) with 'size'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.growToSize(int)"})
  void testGrowToSizeWithSize() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.growToSize(3);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertNull(toListResult.get(0));
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
  }

  /**
   * Test {@link COSArray#growToSize(int, COSBase)} with {@code size}, {@code object}.
   *
   * <p>Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  @DisplayName("Test growToSize(int, COSBase) with 'size', 'object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.growToSize(int, COSBase)"})
  void testGrowToSizeWithSizeObject() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(3L, 3));

    // Act
    cosArray.growToSize(3, object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertSame(object, toListResult.get(0));
    assertSame(object, toListResult.get(1));
    assertSame(object, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#growToSize(int, COSBase)} with {@code size}, {@code object}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first {@link COSObject}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test growToSize(int, COSBase) with 'size', 'object'; then COSArray() toList first COSObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.growToSize(int, COSBase)"})
  void testGrowToSizeWithSizeObject_thenCOSArrayToListFirstCOSObject() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSDictionary object = new COSDictionary();
    object.setKey(new COSObjectKey(3L, 3));

    // Act
    cosArray.growToSize(3, object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSObject);
    assertTrue(toListResult.get(1) instanceof COSObject);
    assertTrue(toListResult.get(2) instanceof COSObject);
  }

  /**
   * Test {@link COSArray#growToSize(int, COSBase)} with {@code size}, {@code object}.
   *
   * <ul>
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test growToSize(int, COSBase) with 'size', 'object'; then COSArray() toList first is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.growToSize(int, COSBase)"})
  void testGrowToSizeWithSizeObject_thenCOSArrayToListFirstIsCOSDictionary() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSDictionary object = new COSDictionary();

    // Act
    cosArray.growToSize(3, object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertSame(object, toListResult.get(0));
    assertSame(object, toListResult.get(1));
    assertSame(object, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#growToSize(int, COSBase)} with {@code size}, {@code object}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSArray#COSArray()} toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test growToSize(int, COSBase) with 'size', 'object'; when COSArray(); then COSArray() toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.growToSize(int, COSBase)"})
  void testGrowToSizeWithSizeObject_whenCOSArray_thenCOSArrayToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSArray object = new COSArray();

    // Act
    cosArray.growToSize(3, object);

    // Assert that nothing has changed
    assertTrue(object.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#growToSize(int, COSBase)} with {@code size}, {@code object}.
   *
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.
   *   <li>Then {@link COSArray#COSArray()} toList first is {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  @DisplayName(
      "Test growToSize(int, COSBase) with 'size', 'object'; when FALSE; then COSArray() toList first is FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.growToSize(int, COSBase)"})
  void testGrowToSizeWithSizeObject_whenFalse_thenCOSArrayToListFirstIsFalse() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.growToSize(3, COSBoolean.FALSE);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    COSBoolean cosBoolean = COSBoolean.FALSE;
    assertSame(cosBoolean, toListResult.get(0));
    assertSame(cosBoolean, toListResult.get(1));
    assertSame(cosBoolean, toListResult.get(2));
  }

  /**
   * Test {@link COSArray#toFloatArray()}.
   *
   * <p>Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  @DisplayName("Test toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] COSArray.toFloatArray()"})
  void testToFloatArray() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);

    // Act and Assert
    assertArrayEquals(new float[] {0.0f}, cosArray.toFloatArray(), 0.0f);
  }

  /**
   * Test {@link COSArray#toFloatArray()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return array of {@code float} with zero.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  @DisplayName(
      "Test toFloatArray(); given COSArray() add FALSE; then return array of float with zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] COSArray.toFloatArray()"})
  void testToFloatArray_givenCOSArrayAddFalse_thenReturnArrayOfFloatWithZero() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertArrayEquals(new float[] {0.0f}, cosArray.toFloatArray(), 0.0f);
  }

  /**
   * Test {@link COSArray#toFloatArray()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  @DisplayName("Test toFloatArray(); given COSArray(); then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] COSArray.toFloatArray()"})
  void testToFloatArray_givenCOSArray_thenReturnEmptyArrayOfFloat() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {}, new COSArray().toFloatArray(), 0.0f);
  }

  /**
   * Test {@link COSArray#toFloatArray()}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  @DisplayName("Test toFloatArray(); then return array of float with ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] COSArray.toFloatArray()"})
  void testToFloatArray_thenReturnArrayOfFloatWithTenAnd05() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act and Assert
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, ofResult.toFloatArray(), 0.0f);
  }

  /**
   * Test {@link COSArray#toFloatArray()}.
   *
   * <ul>
   *   <li>Then return array of {@code float} with ten and forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  @DisplayName("Test toFloatArray(); then return array of float with ten and forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] COSArray.toFloatArray()"})
  void testToFloatArray_thenReturnArrayOfFloatWithTenAndFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act and Assert
    assertArrayEquals(new float[] {10.0f, 42.0f, 10.0f, 0.5f}, ofResult.toFloatArray(), 0.0f);
  }

  /**
   * Test {@link COSArray#setFloatArray(float[])}.
   *
   * <p>Method under test: {@link COSArray#setFloatArray(float[])}
   */
  @Test
  @DisplayName("Test setFloatArray(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.setFloatArray(float[])"})
  void testSetFloatArray() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.setFloatArray(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
  }

  /**
   * Test {@link COSArray#toList()}.
   *
   * <p>Method under test: {@link COSArray#toList()}
   */
  @Test
  @DisplayName("Test toList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toList()"})
  void testToList() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().toList().isEmpty());
  }

  /**
   * Test {@link COSArray#toCOSNameStringList()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNameStringList()}
   */
  @Test
  @DisplayName("Test toCOSNameStringList(); given COSArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNameStringList()"})
  void testToCOSNameStringList_givenCOSArray_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().toCOSNameStringList().isEmpty());
  }

  /**
   * Test {@link COSArray#toCOSNameStringList()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNameStringList()}
   */
  @Test
  @DisplayName("Test toCOSNameStringList(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNameStringList()"})
  void testToCOSNameStringList_thenReturnSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSName.A);

    // Act
    List<String> actualToCOSNameStringListResult = cosArray.toCOSNameStringList();

    // Assert
    assertEquals(1, actualToCOSNameStringListResult.size());
    assertEquals("A", actualToCOSNameStringListResult.get(0));
  }

  /**
   * Test {@link COSArray#toCOSStringStringList()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSStringStringList()}
   */
  @Test
  @DisplayName("Test toCOSStringStringList(); given COSArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSStringStringList()"})
  void testToCOSStringStringList_givenCOSArray_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().toCOSStringStringList().isEmpty());
  }

  /**
   * Test {@link COSArray#toCOSStringStringList()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSStringStringList()}
   */
  @Test
  @DisplayName("Test toCOSStringStringList(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSStringStringList()"})
  void testToCOSStringStringList_thenReturnSizeIsOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSString.parseHex("0123456789ABCDEF"));

    // Act
    List<String> actualToCOSStringStringListResult = cosArray.toCOSStringStringList();

    // Assert
    assertEquals(1, actualToCOSStringStringListResult.size());
    assertEquals("\u0001#Eg›«Íï", actualToCOSStringStringListResult.get(0));
  }

  /**
   * Test {@link COSArray#toCOSNumberFloatList()}.
   *
   * <p>Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  @DisplayName("Test toCOSNumberFloatList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberFloatList()"})
  void testToCOSNumberFloatList() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);

    // Act
    List<Float> actualToCOSNumberFloatListResult = cosArray.toCOSNumberFloatList();

    // Assert
    assertEquals(1, actualToCOSNumberFloatListResult.size());
    assertNull(actualToCOSNumberFloatListResult.get(0));
  }

  /**
   * Test {@link COSArray#toCOSNumberFloatList()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  @DisplayName("Test toCOSNumberFloatList(); given COSArray() add FALSE; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberFloatList()"})
  void testToCOSNumberFloatList_givenCOSArrayAddFalse_thenReturnSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Float> actualToCOSNumberFloatListResult = cosArray.toCOSNumberFloatList();

    // Assert
    assertEquals(1, actualToCOSNumberFloatListResult.size());
    assertNull(actualToCOSNumberFloatListResult.get(0));
  }

  /**
   * Test {@link COSArray#toCOSNumberFloatList()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  @DisplayName("Test toCOSNumberFloatList(); given COSArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberFloatList()"})
  void testToCOSNumberFloatList_givenCOSArray_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().toCOSNumberFloatList().isEmpty());
  }

  /**
   * Test {@link COSArray#toCOSNumberFloatList()}.
   *
   * <ul>
   *   <li>Then return second floatValue is {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  @DisplayName("Test toCOSNumberFloatList(); then return second floatValue is '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberFloatList()"})
  void testToCOSNumberFloatList_thenReturnSecondFloatValueIs05() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    List<Float> actualToCOSNumberFloatListResult = ofResult.toCOSNumberFloatList();

    // Assert
    assertEquals(4, actualToCOSNumberFloatListResult.size());
    assertEquals(0.5f, actualToCOSNumberFloatListResult.get(1).floatValue());
    assertEquals(0.5f, actualToCOSNumberFloatListResult.get(3).floatValue());
    assertEquals(10.0f, actualToCOSNumberFloatListResult.get(0).floatValue());
    assertEquals(10.0f, actualToCOSNumberFloatListResult.get(2).floatValue());
  }

  /**
   * Test {@link COSArray#toCOSNumberFloatList()}.
   *
   * <ul>
   *   <li>Then return second floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  @DisplayName("Test toCOSNumberFloatList(); then return second floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberFloatList()"})
  void testToCOSNumberFloatList_thenReturnSecondFloatValueIsFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act
    List<Float> actualToCOSNumberFloatListResult = ofResult.toCOSNumberFloatList();

    // Assert
    assertEquals(4, actualToCOSNumberFloatListResult.size());
    assertEquals(0.5f, actualToCOSNumberFloatListResult.get(3).floatValue());
    assertEquals(10.0f, actualToCOSNumberFloatListResult.get(0).floatValue());
    assertEquals(10.0f, actualToCOSNumberFloatListResult.get(2).floatValue());
    assertEquals(42.0f, actualToCOSNumberFloatListResult.get(1).floatValue());
  }

  /**
   * Test {@link COSArray#toCOSNumberIntegerList()}.
   *
   * <p>Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  @DisplayName("Test toCOSNumberIntegerList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberIntegerList()"})
  void testToCOSNumberIntegerList() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = cosArray.toCOSNumberIntegerList();

    // Assert
    assertEquals(1, actualToCOSNumberIntegerListResult.size());
    assertNull(actualToCOSNumberIntegerListResult.get(0));
  }

  /**
   * Test {@link COSArray#toCOSNumberIntegerList()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  @DisplayName("Test toCOSNumberIntegerList(); given COSArray() add FALSE; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberIntegerList()"})
  void testToCOSNumberIntegerList_givenCOSArrayAddFalse_thenReturnSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = cosArray.toCOSNumberIntegerList();

    // Assert
    assertEquals(1, actualToCOSNumberIntegerListResult.size());
    assertNull(actualToCOSNumberIntegerListResult.get(0));
  }

  /**
   * Test {@link COSArray#toCOSNumberIntegerList()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  @DisplayName("Test toCOSNumberIntegerList(); given COSArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberIntegerList()"})
  void testToCOSNumberIntegerList_givenCOSArray_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new COSArray().toCOSNumberIntegerList().isEmpty());
  }

  /**
   * Test {@link COSArray#toCOSNumberIntegerList()}.
   *
   * <ul>
   *   <li>Then return second intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  @DisplayName("Test toCOSNumberIntegerList(); then return second intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberIntegerList()"})
  void testToCOSNumberIntegerList_thenReturnSecondIntValueIsFortyTwo() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.set(1, 42);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = ofResult.toCOSNumberIntegerList();

    // Assert
    assertEquals(4, actualToCOSNumberIntegerListResult.size());
    assertEquals(0, actualToCOSNumberIntegerListResult.get(3).intValue());
    assertEquals(10, actualToCOSNumberIntegerListResult.get(0).intValue());
    assertEquals(10, actualToCOSNumberIntegerListResult.get(2).intValue());
    assertEquals(42, actualToCOSNumberIntegerListResult.get(1).intValue());
  }

  /**
   * Test {@link COSArray#toCOSNumberIntegerList()}.
   *
   * <ul>
   *   <li>Then return second intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  @DisplayName("Test toCOSNumberIntegerList(); then return second intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List COSArray.toCOSNumberIntegerList()"})
  void testToCOSNumberIntegerList_thenReturnSecondIntValueIsZero() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = ofResult.toCOSNumberIntegerList();

    // Assert
    assertEquals(4, actualToCOSNumberIntegerListResult.size());
    assertEquals(0, actualToCOSNumberIntegerListResult.get(1).intValue());
    assertEquals(0, actualToCOSNumberIntegerListResult.get(3).intValue());
    assertEquals(10, actualToCOSNumberIntegerListResult.get(0).intValue());
    assertEquals(10, actualToCOSNumberIntegerListResult.get(2).intValue());
  }

  /**
   * Test {@link COSArray#ofCOSIntegers(List)}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSIntegers(List)}
   */
  @Test
  @DisplayName("Test ofCOSIntegers(List); given MIN_VALUE; when ArrayList() add MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSIntegers(List)"})
  void testOfCOSIntegers_givenMin_value_whenArrayListAddMin_value() {
    // Arrange
    ArrayList<Integer> integer = new ArrayList<>();
    integer.add(Integer.MIN_VALUE);

    // Act
    COSArray actualOfCOSIntegersResult = COSArray.ofCOSIntegers(integer);

    // Assert
    List<? extends COSBase> toListResult = actualOfCOSIntegersResult.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Test {@link COSArray#ofCOSIntegers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSIntegers(List)}
   */
  @Test
  @DisplayName("Test ofCOSIntegers(List); when ArrayList(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSIntegers(List)"})
  void testOfCOSIntegers_whenArrayList_thenReturnToListEmpty() {
    // Arrange and Act
    COSArray actualOfCOSIntegersResult = COSArray.ofCOSIntegers(new ArrayList<>());

    // Assert
    assertTrue(actualOfCOSIntegersResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#ofCOSNames(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSNames(List)}
   */
  @Test
  @DisplayName(
      "Test ofCOSNames(List); given '42'; when ArrayList() add '42'; then return toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSNames(List)"})
  void testOfCOSNames_given42_whenArrayListAdd42_thenReturnToListSizeIsTwo() {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("42");
    strings.add("foo");

    // Act
    COSArray actualOfCOSNamesResult = COSArray.ofCOSNames(strings);

    // Assert
    List<? extends COSBase> toListResult = actualOfCOSNamesResult.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    assertEquals("42", ((COSName) getResult).getName());
    assertEquals("foo", ((COSName) getResult2).getName());
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSName) getResult2).isEmpty());
  }

  /**
   * Test {@link COSArray#ofCOSNames(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSNames(List)}
   */
  @Test
  @DisplayName(
      "Test ofCOSNames(List); given 'foo'; when ArrayList() add 'foo'; then return toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSNames(List)"})
  void testOfCOSNames_givenFoo_whenArrayListAddFoo_thenReturnToListSizeIsOne() {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act
    COSArray actualOfCOSNamesResult = COSArray.ofCOSNames(strings);

    // Assert
    List<? extends COSBase> toListResult = actualOfCOSNamesResult.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("foo", ((COSName) getResult).getName());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Test {@link COSArray#ofCOSNames(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSNames(List)}
   */
  @Test
  @DisplayName("Test ofCOSNames(List); when ArrayList(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSNames(List)"})
  void testOfCOSNames_whenArrayList_thenReturnToListEmpty() {
    // Arrange and Act
    COSArray actualOfCOSNamesResult = COSArray.ofCOSNames(new ArrayList<>());

    // Assert
    assertTrue(actualOfCOSNamesResult.toList().isEmpty());
  }

  /**
   * Test {@link COSArray#ofCOSStrings(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSStrings(List)}
   */
  @Test
  @DisplayName(
      "Test ofCOSStrings(List); given '42'; when ArrayList() add '42'; then return toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSStrings(List)"})
  void testOfCOSStrings_given42_whenArrayListAdd42_thenReturnToListSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("42");
    strings.add("foo");

    // Act
    COSArray actualOfCOSStringsResult = COSArray.ofCOSStrings(strings);

    // Assert
    List<? extends COSBase> toListResult = actualOfCOSStringsResult.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSString);
    assertEquals("3432", ((COSString) getResult).toHexString());
    assertEquals("42", ((COSString) getResult).getASCII());
    assertEquals("42", ((COSString) getResult).getString());
    assertEquals("666F6F", ((COSString) getResult2).toHexString());
    assertEquals("foo", ((COSString) getResult2).getASCII());
    assertEquals("foo", ((COSString) getResult2).getString());
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSString) getResult2).getForceHexForm());
    assertArrayEquals("foo".getBytes("UTF-8"), ((COSString) getResult2).getBytes());
    assertArrayEquals(new byte[] {'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSArray#ofCOSStrings(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSStrings(List)}
   */
  @Test
  @DisplayName(
      "Test ofCOSStrings(List); given 'foo'; when ArrayList() add 'foo'; then return toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSStrings(List)"})
  void testOfCOSStrings_givenFoo_whenArrayListAddFoo_thenReturnToListSizeIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act
    COSArray actualOfCOSStringsResult = COSArray.ofCOSStrings(strings);

    // Assert
    List<? extends COSBase> toListResult = actualOfCOSStringsResult.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("666F6F", ((COSString) getResult).toHexString());
    assertEquals("foo", ((COSString) getResult).getASCII());
    assertEquals("foo", ((COSString) getResult).getString());
    assertArrayEquals("foo".getBytes("UTF-8"), ((COSString) getResult).getBytes());
  }

  /**
   * Test {@link COSArray#ofCOSStrings(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#ofCOSStrings(List)}
   */
  @Test
  @DisplayName("Test ofCOSStrings(List); when ArrayList(); then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSArray.ofCOSStrings(List)"})
  void testOfCOSStrings_whenArrayList_thenReturnToListEmpty() {
    // Arrange and Act
    COSArray actualOfCOSStringsResult = COSArray.ofCOSStrings(new ArrayList<>());

    // Assert
    assertTrue(actualOfCOSStringsResult.toList().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSArray#toString()}
   *   <li>{@link COSArray#getUpdateState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSUpdateState COSArray.getUpdateState()", "String COSArray.toString()"})
  void testGettersAndSetters() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    String actualToStringResult = cosArray.toString();
    COSUpdateState actualUpdateState = cosArray.getUpdateState();

    // Assert
    assertEquals("COSArray{[]}", actualToStringResult);
    assertNull(actualUpdateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualUpdateState.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualUpdateState.isAcceptingUpdates());
    assertFalse(actualUpdateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add(COSBoolean.FALSE);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys2() {
    // Arrange
    COSDictionary object = new COSDictionary(new COSDictionary());
    object.setKey(null);

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) object);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSDictionary);
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys3() {
    // Arrange
    COSDictionary object = new COSDictionary(new COSDictionary());
    COSObjectKey key = new COSObjectKey(1L, 1);
    object.setKey(key);

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) object);

    // Act
    cosArray.getIndirectObjectKeys(new ArrayList<>());

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    COSBase object2 = ((COSObject) getResult).getObject();
    assertTrue(object2 instanceof COSDictionary);
    assertTrue(getResult instanceof COSObject);
    assertSame(key, getResult.getKey());
    assertSame(key, object2.getKey());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys4() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.setKey(null);
    cosArray.add(COSBoolean.FALSE);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys5() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) new COSStream());
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSStream);
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} Key is {@link COSObjectKey#COSObjectKey(long, int)}
   *       with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSArray() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSArrayKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    cosArray.setKey(key);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert
    assertEquals(1, indirectObjects.size());
    assertSame(key, indirectObjects.get(0));
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSArray(List) with cosObjectables is ArrayList() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSArrayWithCosObjectablesIsArrayListAddCOSArray() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) new COSArray());
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSArray(List) with cosObjectables is ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSArrayWithCosObjectablesIsArrayListAddNull() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) null);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given COSArray(); when ArrayList(); then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenCOSArray_whenArrayList_thenArrayListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE} Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); given FALSE Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenFalseKeyIsNull() {
    // Arrange
    COSBoolean object = COSBoolean.FALSE;
    object.setKey(null);

    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add(object);
    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertTrue(indirectObjects.isEmpty());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link LinkedHashSet#LinkedHashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given 'null'; then LinkedHashSet() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenNull_thenLinkedHashSetSizeIsOne() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) null);

    LinkedHashSet<COSObjectKey> indirectObjects = new LinkedHashSet<>();
    indirectObjects.add(null);

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then {@link LinkedHashSet#LinkedHashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); given 'null'; then LinkedHashSet() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_givenNull_thenLinkedHashSetSizeIsOne2() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add(COSBoolean.FALSE);

    LinkedHashSet<COSObjectKey> indirectObjects = new LinkedHashSet<>();
    indirectObjects.add(null);

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertEquals(1, indirectObjects.size());
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSObjectKey#COSObjectKey(long, int)} with
   *       num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName(
      "Test getIndirectObjectKeys(Collection); when ArrayList() add COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_whenArrayListAddCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.setKey(new COSObjectKey(1L, 1));

    ArrayList<COSObjectKey> indirectObjects = new ArrayList<>();
    COSObjectKey cosObjectKey = new COSObjectKey(1L, 1);
    indirectObjects.add(cosObjectKey);

    // Act
    cosArray.getIndirectObjectKeys(indirectObjects);

    // Assert that nothing has changed
    assertEquals(1, indirectObjects.size());
    assertSame(cosObjectKey, indirectObjects.get(0));
  }

  /**
   * Test {@link COSArray#getIndirectObjectKeys(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  @DisplayName("Test getIndirectObjectKeys(Collection); when 'null'; then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSArray.getIndirectObjectKeys(Collection)"})
  void testGetIndirectObjectKeys_whenNull_thenNull() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.setKey(null);
    cosArray.add((COSBase) null);

    // Act
    cosArray.getIndirectObjectKeys(null);

    // Assert that nothing has changed
    assertNull(null);
  }
}
