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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class COSArrayDiffblueTest {
  /**
   * Method under test: {@link COSArray#of(float[])}
   */
  @Test
  void testOf() {
    // Arrange, Act and Assert
    List<? extends COSBase> toListResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).toList();
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
   * Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  void testAdd() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSBoolean object = COSBoolean.FALSE;

    // Act
    ofResult.add(2, object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(3) instanceof COSFloat);
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(toListResult.get(1), getResult);
    assertSame(object.FALSE, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#add(int, COSBase)}
   */
  @Test
  void testAdd2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);
    COSObject object2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    ofResult.add(2, object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(3) instanceof COSFloat);
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(toListResult.get(1), getResult);
    assertSame(object2, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  void testAdd3() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSBoolean object = COSBoolean.FALSE;

    // Act
    cosArray.add(object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(object.FALSE, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  void testAdd4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSBoolean object2 = COSBoolean.FALSE;

    // Act
    cosArray.add(object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    COSBoolean cosBoolean = object2.FALSE;
    assertSame(cosBoolean, toListResult.get(0));
    assertSame(cosBoolean, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  void testAdd5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSDictionary object2 = new COSDictionary();

    // Act
    cosArray.add((COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertSame(object2, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  void testAdd6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSArray object2 = new COSArray();

    // Act
    cosArray.add((COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    assertTrue(object2.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  void testAdd7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSObject object2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosArray.add((COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertSame(object2, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#add(COSBase)}
   */
  @Test
  void testAdd8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    COSDictionary object2 = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    object2.setKey(key);

    // Act
    cosArray.add((COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(object2, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  void testAdd9() {
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
   * Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  void testAdd10() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectable object = mock(COSObjectable.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(object.getCOSObject()).thenReturn(cosDictionary);

    // Act
    cosArray.add(object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(cosDictionary, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  void testAdd11() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectable object = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(object.getCOSObject()).thenReturn(cosObject);

    // Act
    cosArray.add(object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertSame(cosObject, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#add(COSObjectable)}
   */
  @Test
  void testAdd12() {
    // Arrange
    COSArray cosArray = new COSArray();

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosDictionary);

    // Act
    cosArray.add(object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertSame(cosDictionary, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Method under test: {@link COSArray#clear()}
   */
  @Test
  void testClear() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.clear();

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#clear()}
   */
  @Test
  void testClear2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.clear();

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.removeAll(new ArrayList<>());

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.removeAll(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.TRUE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll9() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll10() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll11() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSFloat.ONE);

    // Act
    ofResult.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll12() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(new COSFloat(10.0f));

    // Act
    ofResult.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSBoolean);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll13() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.ONE);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll14() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.OUT_OF_RANGE_MAX);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll15() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.A);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeAll(Collection)}
   */
  @Test
  void testRemoveAll16() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.AA);

    // Act
    cosArray.removeAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.retainAll(new ArrayList<>());

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.retainAll(new ArrayList<>());

    // Assert
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.retainAll(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, ofResult.toList().size());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.TRUE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll9() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll10() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll11() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll12() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSFloat.ONE);

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(ofResult.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll13() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(new COSFloat(10.0f));

    // Act
    ofResult.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll14() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.ONE);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll15() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSInteger.OUT_OF_RANGE_MAX);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll16() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.A);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#retainAll(Collection)}
   */
  @Test
  void testRetainAll17() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSName.AA);

    // Act
    cosArray.retainAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  void testAddAll() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.addAll(2, new ArrayList<>());

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
  }

  /**
   * Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  void testAddAll2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectList = new ArrayList<>();
    objectList.add(COSBoolean.FALSE);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(3) instanceof COSFloat);
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(toListResult.get(1), getResult);
  }

  /**
   * Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  void testAddAll3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectList = new ArrayList<>();
    COSArray cosArray = new COSArray();
    objectList.add(cosArray);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(5);
    assertTrue(getResult instanceof COSBoolean);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
    assertEquals(toListResult.get(1), getResult2);
    assertSame(cosArray, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  void testAddAll4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectList = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    objectList.add(cosDictionary);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(6, toListResult.size());
    COSBase getResult = toListResult.get(5);
    assertTrue(getResult instanceof COSBoolean);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    COSBase getResult2 = toListResult.get(4);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
    assertEquals(toListResult.get(1), getResult2);
    assertSame(cosDictionary, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#addAll(int, Collection)}
   */
  @Test
  void testAddAll5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    ArrayList<COSBase> objectList = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    objectList.add(cosObject);

    // Act
    ofResult.addAll(2, objectList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(6, toListResult.size());
    assertTrue(toListResult.get(3) instanceof COSFloat);
    COSBase getResult = toListResult.get(4);
    assertTrue(getResult instanceof COSFloat);
    assertEquals(toListResult.get(1), getResult);
    assertSame(cosObject, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll6() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.addAll(new ArrayList<>());

    // Assert
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.addAll(new ArrayList<>());

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll9() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    objectsList.add(COSBoolean.FALSE);
    objectsList.add(COSBoolean.FALSE);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    assertEquals(3, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll10() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSArray cosArray2 = new COSArray();
    objectsList.add(cosArray2);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertSame(cosArray2, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll11() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSDictionary cosDictionary = new COSDictionary();
    objectsList.add(cosDictionary);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertSame(cosDictionary, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#addAll(Collection)}
   */
  @Test
  void testAddAll12() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    ArrayList<COSBase> objectsList = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    objectsList.add(cosObject);

    // Act
    cosArray.addAll(objectsList);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertSame(cosObject, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#addAll(COSArray)}
   */
  @Test
  void testAddAll13() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSArray objectList = new COSArray();

    // Act
    cosArray.addAll(objectList);

    // Assert
    assertTrue(objectList.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#addAll(COSArray)}
   */
  @Test
  void testAddAll14() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSArray objectList = new COSArray();

    // Act
    cosArray.addAll(objectList);

    // Assert
    verify(object).getCOSObject();
    assertTrue(objectList.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#addAll(COSArray)}
   */
  @Test
  void testAddAll15() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.addAll((COSArray) null);

    // Assert that nothing has changed
    verify(object).getCOSObject();
    assertEquals(1, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#addAll(COSArray)}
   */
  @Test
  void testAddAll16() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.addAll(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f));

    // Assert
    verify(object).getCOSObject();
    assertEquals(5, cosArray.toList().size());
  }

  /**
   * Method under test: {@link COSArray#set(int, int)}
   */
  @Test
  void testSet() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    ofResult.set(1, 42);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSInteger);
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  void testSet2() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSBoolean object = COSBoolean.FALSE;

    // Act
    ofResult.set(1, object);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    assertSame(object.FALSE, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  void testSet3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);
    COSDictionary object2 = new COSDictionary();

    // Act
    ofResult.set(1, (COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertSame(object2, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  void testSet4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);
    COSArray object2 = new COSArray();

    // Act
    ofResult.set(1, (COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertSame(object2, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  void testSet5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);
    COSObject object2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    ofResult.set(1, (COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    assertSame(object2, toListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#set(int, COSBase)}
   */
  @Test
  void testSet6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);

    COSDictionary object2 = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    object2.setKey(key);

    // Act
    ofResult.set(1, (COSBase) object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(1);
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
    assertSame(object2, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  void testSet7() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

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
   * Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  void testSet8() {
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
   * Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  void testSet9() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObjectable object = mock(COSObjectable.class);
    COSDictionary cosDictionary = new COSDictionary();
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
   * Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  void testSet10() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    COSObjectable object = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

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
   * Method under test: {@link COSArray#set(int, COSObjectable)}
   */
  @Test
  void testSet11() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(cosDictionary);

    // Act
    ofResult.set(1, object);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
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
    assertSame(cosDictionary, ((COSObject) getResult).getObject());
    assertSame(key, getResult.getKey());
  }

  /**
   * Method under test: {@link COSArray#getObject(int)}
   */
  @Test
  void testGetObject() {
    // Arrange and Act
    COSBase actualObject = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getObject(1);

    // Assert
    assertTrue(actualObject instanceof COSFloat);
    assertNull(actualObject.getKey());
    assertFalse(actualObject.isDirect());
  }

  /**
   * Method under test: {@link COSArray#getObject(int)}
   */
  @Test
  void testGetObject2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(object.getCOSObject()).thenReturn(cosObject);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    // Act
    COSBase actualObject = cosArray.getObject(1);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSObject);
    assertSame(cosObject, getResult);
    COSBoolean cosBoolean = ((COSBoolean) actualObject).FALSE;
    assertSame(cosBoolean, toListResult.get(0));
    assertSame(cosBoolean, actualObject);
    assertSame(cosBoolean, ((COSObject) getResult).getObject());
  }

  /**
   * Method under test: {@link COSArray#get(int)}
   */
  @Test
  void testGet() {
    // Arrange and Act
    COSBase actualGetResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).get(1);

    // Assert
    assertTrue(actualGetResult instanceof COSFloat);
    assertNull(actualGetResult.getKey());
    assertFalse(actualGetResult.isDirect());
  }

  /**
   * Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  void testGetInt() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSArray()).getInt(1));
    assertEquals(0, COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getInt(1));
    assertEquals(42, (new COSArray()).getInt(1, 42));
    assertEquals(0, COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getInt(1, 42));
  }

  /**
   * Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  void testGetInt2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(1);

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  void testGetInt3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(1);

    // Assert
    verify(object).getCOSObject();
    assertEquals(-1, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int)}
   */
  @Test
  void testGetInt4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(1);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  void testGetInt5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(1, 42);

    // Assert
    verify(object).getCOSObject();
    assertEquals(42, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  void testGetInt6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(1, 42);

    // Assert
    verify(object).getCOSObject();
    assertEquals(42, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  void testGetInt7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(3, 42);

    // Assert
    verify(object).getCOSObject();
    assertEquals(42, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  void testGetInt8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(0, 42);

    // Assert
    verify(object).getCOSObject();
    assertEquals(42, actualInt);
  }

  /**
   * Method under test: {@link COSArray#getInt(int, int)}
   */
  @Test
  void testGetInt9() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    // Act
    int actualInt = cosArray.getInt(1, 42);

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, actualInt);
  }

  /**
   * Method under test: {@link COSArray#setInt(int, int)}
   */
  @Test
  void testSetInt() {
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
   * Method under test: {@link COSArray#setName(int, String)}
   */
  @Test
  void testSetName() {
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
   * Method under test: {@link COSArray#getName(int)}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new COSArray()).getName(1));
    assertNull(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getName(1));
    assertEquals("42", (new COSArray()).getName(1, "42"));
    assertEquals("42", COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getName(1, "42"));
  }

  /**
   * Method under test: {@link COSArray#getName(int)}
   */
  @Test
  void testGetName2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    String actualName = cosArray.getName(1);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualName);
  }

  /**
   * Method under test: {@link COSArray#getName(int)}
   */
  @Test
  void testGetName3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.A);

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(object);

    // Act
    String actualName = cosArray.getName(1);

    // Assert
    verify(object).getCOSObject();
    assertEquals("A", actualName);
  }

  /**
   * Method under test: {@link COSArray#getName(int, String)}
   */
  @Test
  void testGetName4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    String actualName = cosArray.getName(1, "42");

    // Assert
    verify(object).getCOSObject();
    assertEquals("42", actualName);
  }

  /**
   * Method under test: {@link COSArray#setString(int, String)}
   */
  @Test
  void testSetString() throws UnsupportedEncodingException {
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
    byte[] expectedBytes = "String".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link COSArray#getString(int)}
   */
  @Test
  void testGetString() {
    // Arrange, Act and Assert
    assertNull((new COSArray()).getString(1));
    assertNull(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getString(1));
    assertEquals("42", (new COSArray()).getString(1, "42"));
    assertEquals("42", COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).getString(1, "42"));
  }

  /**
   * Method under test: {@link COSArray#getString(int)}
   */
  @Test
  void testGetString2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    String actualString = cosArray.getString(1);

    // Assert
    verify(object).getCOSObject();
    assertNull(actualString);
  }

  /**
   * Method under test: {@link COSArray#getString(int, String)}
   */
  @Test
  void testGetString3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    String actualString = cosArray.getString(1, "42");

    // Assert
    verify(object).getCOSObject();
    assertEquals("42", actualString);
  }

  /**
   * Method under test: {@link COSArray#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new COSArray()).size());
  }

  /**
   * Method under test: {@link COSArray#size()}
   */
  @Test
  void testSize2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    int actualSizeResult = cosArray.size();

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, actualSizeResult);
  }

  /**
   * Method under test: {@link COSArray#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).isEmpty());
    assertFalse(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).isEmpty());
  }

  /**
   * Method under test: {@link COSArray#isEmpty()}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    boolean actualIsEmptyResult = cosArray.isEmpty();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualIsEmptyResult);
  }

  /**
   * Method under test: {@link COSArray#remove(int)}
   */
  @Test
  void testRemove() {
    // Arrange
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    COSBase actualRemoveResult = ofResult.remove(1);

    // Assert
    List<? extends COSBase> toListResult = ofResult.toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertTrue(actualRemoveResult instanceof COSFloat);
    assertNull(actualRemoveResult.getKey());
    assertFalse(actualRemoveResult.isDirect());
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove2() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act and Assert
    assertFalse(cosArray.remove(COSBoolean.FALSE));
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove3() {
    // Arrange, Act and Assert
    assertFalse(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).remove(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove4() {
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
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);
    COSBoolean o = COSBoolean.FALSE;

    // Act
    boolean actualRemoveResult = cosArray.remove(o);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(actualRemoveResult);
    assertSame(o.FALSE, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);
    ofResult.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveResult = ofResult.remove(COSFloat.ONE);

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.OUT_OF_RANGE_MAX);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);
    COSInteger o = COSInteger.ONE;

    // Act
    boolean actualRemoveResult = cosArray.remove(o);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveResult);
    assertSame(o.OUT_OF_RANGE_MAX, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.AA);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);
    COSName o = COSName.A;

    // Act
    boolean actualRemoveResult = cosArray.remove(o);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveResult);
    assertSame(o.AA, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#remove(COSBase)}
   */
  @Test
  void testRemove9() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSString cosString = new COSString("Text");
    when(object.getCOSObject()).thenReturn(cosString);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveResult = cosArray.remove(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveResult);
    assertSame(cosString, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act and Assert
    assertFalse(cosArray.removeObject(COSBoolean.FALSE));
    assertTrue(cosArray.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject2() {
    // Arrange, Act and Assert
    assertFalse(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).removeObject(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject3() {
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
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);
    COSBoolean o = COSBoolean.FALSE;

    // Act
    boolean actualRemoveObjectResult = cosArray.removeObject(o);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(1, toListResult.size());
    assertTrue(actualRemoveObjectResult);
    assertSame(o.FALSE, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSArray ofResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);
    ofResult.add(object);
    ofResult.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectResult = ofResult.removeObject(COSFloat.ONE);

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualRemoveObjectResult);
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(object.getCOSObject()).thenReturn(cosObject);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectResult = cosArray.removeObject(COSFloat.ONE);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveObjectResult);
    assertSame(cosObject, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.OUT_OF_RANGE_MAX);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);
    COSInteger o = COSInteger.ONE;

    // Act
    boolean actualRemoveObjectResult = cosArray.removeObject(o);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveObjectResult);
    assertSame(o.OUT_OF_RANGE_MAX, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSName.AA);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);
    COSName o = COSName.A;

    // Act
    boolean actualRemoveObjectResult = cosArray.removeObject(o);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveObjectResult);
    assertSame(o.AA, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#removeObject(COSBase)}
   */
  @Test
  void testRemoveObject9() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSString cosString = new COSString("Text");
    when(object.getCOSObject()).thenReturn(cosString);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    boolean actualRemoveObjectResult = cosArray.removeObject(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(2, toListResult.size());
    assertFalse(actualRemoveObjectResult);
    assertSame(cosString, toListResult.get(0));
  }

  /**
   * Method under test: {@link COSArray#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new COSArray()).iterator().hasNext());
  }

  /**
   * Method under test: {@link COSArray#indexOf(COSBase)}
   */
  @Test
  void testIndexOf() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSArray()).indexOf(COSBoolean.FALSE));
    assertEquals(-1, COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).indexOf(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSArray#indexOf(COSBase)}
   */
  @Test
  void testIndexOf2() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertEquals(0, cosArray.indexOf(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSArray#indexOf(COSBase)}
   */
  @Test
  void testIndexOf3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    int actualIndexOfResult = cosArray.indexOf(COSBoolean.FALSE);

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualIndexOfResult);
  }

  /**
   * Method under test: {@link COSArray#indexOfObject(COSBase)}
   */
  @Test
  void testIndexOfObject() {
    // Arrange, Act and Assert
    assertEquals(-1, (new COSArray()).indexOfObject(COSBoolean.FALSE));
    assertEquals(-1, COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).indexOfObject(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSArray#indexOfObject(COSBase)}
   */
  @Test
  void testIndexOfObject2() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertEquals(0, cosArray.indexOfObject(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSArray#indexOfObject(COSBase)}
   */
  @Test
  void testIndexOfObject3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    int actualIndexOfObjectResult = cosArray.indexOfObject(COSBoolean.FALSE);

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualIndexOfObjectResult);
  }

  /**
   * Method under test: {@link COSArray#growToSize(int)}
   */
  @Test
  void testGrowToSize() {
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
   * Method under test: {@link COSArray#growToSize(int)}
   */
  @Test
  void testGrowToSize2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.growToSize(3);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertNull(toListResult.get(1));
    assertNull(toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  void testGrowToSize3() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSBoolean object = COSBoolean.FALSE;

    // Act
    cosArray.growToSize(3, object);

    // Assert
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    COSBoolean cosBoolean = object.FALSE;
    assertSame(cosBoolean, toListResult.get(0));
    assertSame(cosBoolean, toListResult.get(1));
    assertSame(cosBoolean, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  void testGrowToSize4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSBoolean object2 = COSBoolean.FALSE;

    // Act
    cosArray.growToSize(3, object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    COSBoolean cosBoolean = object2.FALSE;
    assertSame(cosBoolean, toListResult.get(0));
    assertSame(cosBoolean, toListResult.get(1));
    assertSame(cosBoolean, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  void testGrowToSize5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSDictionary object2 = new COSDictionary();

    // Act
    cosArray.growToSize(3, object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    assertSame(object2, toListResult.get(1));
    assertSame(object2, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  void testGrowToSize6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSArray object2 = new COSArray();

    // Act
    cosArray.growToSize(3, object2);

    // Assert
    verify(object).getCOSObject();
    assertTrue(object2.toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  void testGrowToSize7() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    COSObject object2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(3L, 3));

    // Act
    cosArray.growToSize(3, object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertSame(object2, toListResult.get(1));
    assertSame(object2, toListResult.get(2));
  }

  /**
   * Method under test: {@link COSArray#growToSize(int, COSBase)}
   */
  @Test
  void testGrowToSize8() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    COSDictionary object2 = new COSDictionary();
    COSObjectKey key = new COSObjectKey(3L, 3);

    object2.setKey(key);

    // Act
    cosArray.growToSize(3, object2);

    // Assert
    verify(object).getCOSObject();
    List<? extends COSBase> toListResult = cosArray.toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSBoolean);
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSObject);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSObject);
    COSUpdateState updateState = ((COSObject) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSUpdateState updateState2 = ((COSObject) getResult2).getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = ((COSObject) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = ((COSObject) getResult2).toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    COSIncrement toIncrementResult3 = updateState.toIncrement();
    assertFalse(toIncrementResult3.iterator().hasNext());
    COSIncrement toIncrementResult4 = updateState2.toIncrement();
    assertFalse(toIncrementResult4.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSObject) getResult).isObjectNull());
    assertFalse(((COSObject) getResult2).isObjectNull());
    assertFalse(((COSObject) getResult).isNeedToBeUpdated());
    assertFalse(((COSObject) getResult2).isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState2.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(toIncrementResult3.getObjects().isEmpty());
    assertTrue(toIncrementResult4.getObjects().isEmpty());
    assertTrue(((COSObject) getResult).isDereferenced());
    assertTrue(((COSObject) getResult2).isDereferenced());
    assertSame(object2, ((COSObject) getResult).getObject());
    assertSame(object2, ((COSObject) getResult2).getObject());
    assertSame(key, getResult.getKey());
    assertSame(key, getResult2.getKey());
  }

  /**
   * Method under test: {@link COSArray#accept(ICOSVisitor)}
   */
  @Test
  void testAccept() throws IOException {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    cosArray.accept(new COSWriter(new ByteArrayOutputStream(1)));

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  void testToFloatArray() {
    // Arrange, Act and Assert
    assertEquals(0, (new COSArray()).toFloatArray().length);
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).toFloatArray(),
        0.0f);
  }

  /**
   * Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  void testToFloatArray2() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    // Act and Assert
    assertArrayEquals(new float[]{0.0f}, cosArray.toFloatArray(), 0.0f);
  }

  /**
   * Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  void testToFloatArray3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    float[] actualToFloatArrayResult = cosArray.toFloatArray();

    // Assert
    verify(object).getCOSObject();
    assertArrayEquals(new float[]{0.0f, 0.0f}, actualToFloatArrayResult, 0.0f);
  }

  /**
   * Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  void testToFloatArray4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    float[] actualToFloatArrayResult = cosArray.toFloatArray();

    // Assert
    verify(object).getCOSObject();
    assertArrayEquals(new float[]{1.0f, 0.0f}, actualToFloatArrayResult, 0.0f);
  }

  /**
   * Method under test: {@link COSArray#toFloatArray()}
   */
  @Test
  void testToFloatArray5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    float[] actualToFloatArrayResult = cosArray.toFloatArray();

    // Assert
    verify(object).getCOSObject();
    assertArrayEquals(new float[]{0.0f, 0.0f}, actualToFloatArrayResult, 0.0f);
  }

  /**
   * Method under test: {@link COSArray#setFloatArray(float[])}
   */
  @Test
  void testSetFloatArray() {
    // Arrange
    COSArray cosArray = new COSArray();

    // Act
    cosArray.setFloatArray(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

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
   * Method under test: {@link COSArray#setFloatArray(float[])}
   */
  @Test
  void testSetFloatArray2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.setFloatArray(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    verify(object).getCOSObject();
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
   * Method under test: {@link COSArray#toList()}
   */
  @Test
  void testToList() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#toList()}
   */
  @Test
  void testToList2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    List<? extends COSBase> actualToListResult = cosArray.toList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(1, actualToListResult.size());
    COSBase getResult = actualToListResult.get(0);
    assertTrue(getResult instanceof COSBoolean);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSBoolean) getResult).getValue());
    assertFalse(((COSBoolean) getResult).getValueAsObject());
  }

  /**
   * Method under test: {@link COSArray#toCOSNameStringList()}
   */
  @Test
  void testToCOSNameStringList() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).toCOSNameStringList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#toCOSStringStringList()}
   */
  @Test
  void testToCOSStringStringList() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).toCOSStringStringList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  void testToCOSNumberFloatList() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).toCOSNumberFloatList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  void testToCOSNumberFloatList2() {
    // Arrange and Act
    List<Float> actualToCOSNumberFloatListResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).toCOSNumberFloatList();

    // Assert
    assertEquals(4, actualToCOSNumberFloatListResult.size());
    assertEquals(0.5f, actualToCOSNumberFloatListResult.get(1).floatValue());
    assertEquals(0.5f, actualToCOSNumberFloatListResult.get(3).floatValue());
    assertEquals(10.0f, actualToCOSNumberFloatListResult.get(0).floatValue());
    assertEquals(10.0f, actualToCOSNumberFloatListResult.get(2).floatValue());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  void testToCOSNumberFloatList3() {
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
   * Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  void testToCOSNumberFloatList4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Float> actualToCOSNumberFloatListResult = cosArray.toCOSNumberFloatList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, actualToCOSNumberFloatListResult.size());
    assertNull(actualToCOSNumberFloatListResult.get(0));
    assertNull(actualToCOSNumberFloatListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  void testToCOSNumberFloatList5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Float> actualToCOSNumberFloatListResult = cosArray.toCOSNumberFloatList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, actualToCOSNumberFloatListResult.size());
    assertNull(actualToCOSNumberFloatListResult.get(1));
    assertEquals(1.0f, actualToCOSNumberFloatListResult.get(0).floatValue());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberFloatList()}
   */
  @Test
  void testToCOSNumberFloatList6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Float> actualToCOSNumberFloatListResult = cosArray.toCOSNumberFloatList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, actualToCOSNumberFloatListResult.size());
    assertNull(actualToCOSNumberFloatListResult.get(0));
    assertNull(actualToCOSNumberFloatListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  void testToCOSNumberIntegerList() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).toCOSNumberIntegerList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  void testToCOSNumberIntegerList2() {
    // Arrange and Act
    List<Integer> actualToCOSNumberIntegerListResult = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f).toCOSNumberIntegerList();

    // Assert
    assertEquals(4, actualToCOSNumberIntegerListResult.size());
    assertEquals(0, actualToCOSNumberIntegerListResult.get(1).intValue());
    assertEquals(0, actualToCOSNumberIntegerListResult.get(3).intValue());
    assertEquals(10, actualToCOSNumberIntegerListResult.get(0).intValue());
    assertEquals(10, actualToCOSNumberIntegerListResult.get(2).intValue());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  void testToCOSNumberIntegerList3() {
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
   * Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  void testToCOSNumberIntegerList4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = cosArray.toCOSNumberIntegerList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, actualToCOSNumberIntegerListResult.size());
    assertNull(actualToCOSNumberIntegerListResult.get(0));
    assertNull(actualToCOSNumberIntegerListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  void testToCOSNumberIntegerList5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSInteger.ONE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = cosArray.toCOSNumberIntegerList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, actualToCOSNumberIntegerListResult.size());
    assertNull(actualToCOSNumberIntegerListResult.get(1));
    assertEquals(1, actualToCOSNumberIntegerListResult.get(0).intValue());
  }

  /**
   * Method under test: {@link COSArray#toCOSNumberIntegerList()}
   */
  @Test
  void testToCOSNumberIntegerList6() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));

    COSArray cosArray = new COSArray();
    cosArray.add(object);
    cosArray.add(COSBoolean.FALSE);

    // Act
    List<Integer> actualToCOSNumberIntegerListResult = cosArray.toCOSNumberIntegerList();

    // Assert
    verify(object).getCOSObject();
    assertEquals(2, actualToCOSNumberIntegerListResult.size());
    assertNull(actualToCOSNumberIntegerListResult.get(0));
    assertNull(actualToCOSNumberIntegerListResult.get(1));
  }

  /**
   * Method under test: {@link COSArray#ofCOSIntegers(List)}
   */
  @Test
  void testOfCOSIntegers() {
    // Arrange, Act and Assert
    assertTrue(COSArray.ofCOSIntegers(new ArrayList<>()).toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#ofCOSIntegers(List)}
   */
  @Test
  void testOfCOSIntegers2() {
    // Arrange
    ArrayList<Integer> integer = new ArrayList<>();
    integer.add(-100);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArray.ofCOSIntegers(integer).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Method under test: {@link COSArray#ofCOSIntegers(List)}
   */
  @Test
  void testOfCOSIntegers3() {
    // Arrange
    ArrayList<Integer> integer = new ArrayList<>();
    integer.add(Integer.MIN_VALUE);

    // Act and Assert
    List<? extends COSBase> toListResult = COSArray.ofCOSIntegers(integer).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertTrue(((COSInteger) getResult).isValid());
  }

  /**
   * Method under test: {@link COSArray#ofCOSNames(List)}
   */
  @Test
  void testOfCOSNames() {
    // Arrange, Act and Assert
    assertTrue(COSArray.ofCOSNames(new ArrayList<>()).toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#ofCOSNames(List)}
   */
  @Test
  void testOfCOSNames2() {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act and Assert
    List<? extends COSBase> toListResult = COSArray.ofCOSNames(strings).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertEquals("foo", ((COSName) getResult).getName());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
  }

  /**
   * Method under test: {@link COSArray#ofCOSNames(List)}
   */
  @Test
  void testOfCOSNames3() {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("42");
    strings.add("foo");

    // Act and Assert
    List<? extends COSBase> toListResult = COSArray.ofCOSNames(strings).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    assertEquals("42", ((COSName) getResult).getName());
    assertEquals("foo", ((COSName) getResult2).getName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
    assertFalse(((COSName) getResult2).isEmpty());
  }

  /**
   * Method under test: {@link COSArray#ofCOSStrings(List)}
   */
  @Test
  void testOfCOSStrings() {
    // Arrange, Act and Assert
    assertTrue(COSArray.ofCOSStrings(new ArrayList<>()).toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#ofCOSStrings(List)}
   */
  @Test
  void testOfCOSStrings2() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("foo");

    // Act and Assert
    List<? extends COSBase> toListResult = COSArray.ofCOSStrings(strings).toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSString);
    assertEquals("666F6F", ((COSString) getResult).toHexString());
    assertEquals("foo", ((COSString) getResult).getASCII());
    assertEquals("foo", ((COSString) getResult).getString());
    assertNull(getResult.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    byte[] expectedBytes = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link COSArray#ofCOSStrings(List)}
   */
  @Test
  void testOfCOSStrings3() throws UnsupportedEncodingException {
    // Arrange
    ArrayList<String> strings = new ArrayList<>();
    strings.add("42");
    strings.add("foo");

    // Act and Assert
    List<? extends COSBase> toListResult = COSArray.ofCOSStrings(strings).toList();
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(((COSString) getResult).getForceHexForm());
    assertFalse(((COSString) getResult2).getForceHexForm());
    byte[] expectedBytes = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) getResult2).getBytes());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) getResult).getBytes());
  }

  /**
   * Method under test: {@link COSArray#getIndirectObjectKeys(Collection)}
   */
  @Test
  void testGetIndirectObjectKeys() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray cosArray = new COSArray();
    cosArray.add(object);

    // Act
    cosArray.getIndirectObjectKeys(new ArrayList<>());

    // Assert that nothing has changed
    verify(object).getCOSObject();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSArray#toString()}
   *   <li>{@link COSArray#getUpdateState()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link COSArray#COSArray()}
   */
  @Test
  void testNewCOSArray() {
    // Arrange, Act and Assert
    assertTrue((new COSArray()).toList().isEmpty());
    assertTrue((new COSArray(new ArrayList<>())).toList().isEmpty());
  }

  /**
   * Method under test: {@link COSArray#COSArray(List)}
   */
  @Test
  void testNewCOSArray2() {
    // Arrange
    ArrayList<? extends COSObjectable> cosObjectables = new ArrayList<>();
    cosObjectables.add(null);

    // Act and Assert
    List<? extends COSBase> toListResult = (new COSArray(cosObjectables)).toList();
    assertEquals(1, toListResult.size());
    assertNull(toListResult.get(0));
  }
}
