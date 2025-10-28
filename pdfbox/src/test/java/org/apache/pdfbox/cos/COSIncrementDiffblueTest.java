package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Iterator;
import java.util.Set;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class COSIncrementDiffblueTest {
  /**
   * Method under test: {@link COSIncrement#contains(COSBase)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSArray())).contains(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSIncrement#contains(COSBase)}
   */
  @Test
  void testContains2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    boolean actualContainsResult = (new COSIncrement(incrementOrigin)).contains(COSBoolean.FALSE);

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSIncrement#contains(COSBase)}
   */
  @Test
  void testContains3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);
    COSIncrement cosIncrement = new COSIncrement(incrementOrigin);

    // Act
    boolean actualContainsResult = cosIncrement
        .contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSIncrement#exclude(COSBase[])}
   */
  @Test
  void testExclude() {
    // Arrange
    COSIncrement cosIncrement = new COSIncrement(new COSArray());

    // Act and Assert
    assertSame(cosIncrement, cosIncrement.exclude(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSIncrement#exclude(COSBase[])}
   */
  @Test
  void testExclude2() {
    // Arrange
    COSIncrement cosIncrement = new COSIncrement(new COSArray());

    // Act and Assert
    assertSame(cosIncrement, cosIncrement.exclude(null));
  }

  /**
   * Method under test: {@link COSIncrement#exclude(COSBase[])}
   */
  @Test
  void testExclude3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);
    COSIncrement cosIncrement = new COSIncrement(incrementOrigin);

    // Act
    COSIncrement actualExcludeResult = cosIncrement.exclude(COSBoolean.FALSE);

    // Assert
    verify(object).getCOSObject();
    assertSame(cosIncrement, actualExcludeResult);
  }

  /**
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  void testGetObjects() {
    // Arrange, Act and Assert
    assertTrue((new COSIncrement(new COSArray())).getObjects().isEmpty());
    assertTrue((new COSIncrement(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)))).getObjects().isEmpty());
    assertTrue((new COSIncrement(null)).getObjects().isEmpty());
    assertTrue((new COSIncrement(new COSDictionary())).getObjects().isEmpty());
    assertTrue((new COSIncrement(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f))).getObjects().isEmpty());
    assertTrue((new COSIncrement(new COSStream())).getObjects().isEmpty());
  }

  /**
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  void testGetObjects2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Set<COSBase> actualObjects = (new COSIncrement(incrementOrigin)).getObjects();

    // Assert
    verify(object).getCOSObject();
    assertTrue(actualObjects.isEmpty());
  }

  /**
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  void testGetObjects3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Set<COSBase> actualObjects = (new COSIncrement(incrementOrigin)).getObjects();

    // Assert
    verify(object).getCOSObject();
    assertTrue(actualObjects.isEmpty());
  }

  /**
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  void testGetObjects4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSObject object2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(object.getCOSObject()).thenReturn(new COSObject(object2, new COSObjectKey(1L, 1)));

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Set<COSBase> actualObjects = (new COSIncrement(incrementOrigin)).getObjects();

    // Assert
    verify(object).getCOSObject();
    assertTrue(actualObjects.isEmpty());
  }

  /**
   * Method under test: {@link COSIncrement#getObjects()}
   */
  @Test
  void testGetObjects5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSDictionary object2 = new COSDictionary();
    when(object.getCOSObject()).thenReturn(new COSObject(object2, new COSObjectKey(1L, 1)));

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Set<COSBase> actualObjects = (new COSIncrement(incrementOrigin)).getObjects();

    // Assert
    verify(object).getCOSObject();
    assertTrue(actualObjects.isEmpty());
  }

  /**
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new COSIncrement(new COSArray())).iterator().hasNext());
    assertFalse((new COSIncrement(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)))).iterator().hasNext());
    assertFalse((new COSIncrement(null)).iterator().hasNext());
    assertFalse((new COSIncrement(new COSDictionary())).iterator().hasNext());
    assertFalse((new COSIncrement(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f))).iterator().hasNext());
    assertFalse((new COSIncrement(new COSStream())).iterator().hasNext());
  }

  /**
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  void testIterator2() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Iterator<COSBase> actualIteratorResult = (new COSIncrement(incrementOrigin)).iterator();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  void testIterator3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Iterator<COSBase> actualIteratorResult = (new COSIncrement(incrementOrigin)).iterator();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  void testIterator4() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSObject object2 = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(object.getCOSObject()).thenReturn(new COSObject(object2, new COSObjectKey(1L, 1)));

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Iterator<COSBase> actualIteratorResult = (new COSIncrement(incrementOrigin)).iterator();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link COSIncrement#iterator()}
   */
  @Test
  void testIterator5() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    COSDictionary object2 = new COSDictionary();
    when(object.getCOSObject()).thenReturn(new COSObject(object2, new COSObjectKey(1L, 1)));

    COSArray incrementOrigin = new COSArray();
    incrementOrigin.add(object);

    // Act
    Iterator<COSBase> actualIteratorResult = (new COSIncrement(incrementOrigin)).iterator();

    // Assert
    verify(object).getCOSObject();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link COSIncrement#COSIncrement(COSUpdateInfo)}
   */
  @Test
  void testNewCOSIncrement() {
    // Arrange and Act
    COSIncrement actualCosIncrement = new COSIncrement(new COSArray());

    // Assert
    assertFalse(actualCosIncrement.iterator().hasNext());
    assertTrue(actualCosIncrement.getObjects().isEmpty());
  }
}
