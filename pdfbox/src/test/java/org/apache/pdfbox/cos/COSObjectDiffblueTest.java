package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSObjectDiffblueTest {
  /**
   * Test {@link COSObject#COSObject(COSBase)}.
   * <p>
   * Method under test: {@link COSObject#COSObject(COSBase)}
   */
  @Test
  @DisplayName("Test new COSObject(COSBase)")
  void testNewCOSObject() {
    // Arrange
    COSBoolean object = COSBoolean.FALSE;

    // Act
    COSObject actualCosObject = new COSObject(object);

    // Assert
    COSUpdateState updateState = actualCosObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosObject.getKey());
    COSIncrement toIncrementResult = actualCosObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosObject.isDirect());
    assertFalse(actualCosObject.isObjectNull());
    assertFalse(actualCosObject.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCosObject.isDereferenced());
    COSBoolean expectedObject = object.FALSE;
    assertSame(expectedObject, actualCosObject.getObject());
  }

  /**
   * Test {@link COSObject#COSObject(COSBase, COSObjectKey)}.
   * <p>
   * Method under test: {@link COSObject#COSObject(COSBase, COSObjectKey)}
   */
  @Test
  @DisplayName("Test new COSObject(COSBase, COSObjectKey)")
  void testNewCOSObject2() {
    // Arrange
    COSBoolean object = COSBoolean.FALSE;
    COSObjectKey objectKey = new COSObjectKey(1L, 1);

    // Act
    COSObject actualCosObject = new COSObject(object, objectKey);

    // Assert
    COSUpdateState updateState = actualCosObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualCosObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosObject.isDirect());
    assertFalse(actualCosObject.isObjectNull());
    assertFalse(actualCosObject.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCosObject.isDereferenced());
    assertSame(objectKey, actualCosObject.getKey());
    COSBoolean expectedObject = object.FALSE;
    assertSame(expectedObject, actualCosObject.getObject());
  }

  /**
   * Test {@link COSObject#COSObject(COSObjectKey, ICOSParser)}.
   * <p>
   * Method under test: {@link COSObject#COSObject(COSObjectKey, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSObject(COSObjectKey, ICOSParser)")
  void testNewCOSObject3() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObject actualCosObject = new COSObject(key,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    assertNull(actualCosObject.getObject());
    COSUpdateState updateState = actualCosObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualCosObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosObject.isDirect());
    assertFalse(actualCosObject.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCosObject.isDereferenced());
    assertTrue(actualCosObject.isObjectNull());
    assertSame(key, actualCosObject.getKey());
  }

  /**
   * Test {@link COSObject#COSObject(COSBase, ICOSParser)}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then return not ObjectNull.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObject#COSObject(COSBase, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSObject(COSBase, ICOSParser); when FALSE; then return not ObjectNull")
  void testNewCOSObject_whenFalse_thenReturnNotObjectNull() throws IOException {
    // Arrange
    COSBoolean object = COSBoolean.FALSE;

    // Act
    COSObject actualCosObject = new COSObject(object,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    assertFalse(actualCosObject.isObjectNull());
    COSBoolean expectedObject = object.FALSE;
    assertSame(expectedObject, actualCosObject.getObject());
  }

  /**
   * Test {@link COSObject#isObjectNull()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObject#isObjectNull()}
   */
  @Test
  @DisplayName("Test isObjectNull(); then return 'false'")
  void testIsObjectNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))).isObjectNull());
  }

  /**
   * Test {@link COSObject#isObjectNull()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObject#isObjectNull()}
   */
  @Test
  @DisplayName("Test isObjectNull(); then return 'true'")
  void testIsObjectNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSObject(null, new COSObjectKey(1L, 1))).isObjectNull());
  }

  /**
   * Test {@link COSObject#getObject()}.
   * <p>
   * Method under test: {@link COSObject#getObject()}
   */
  @Test
  @DisplayName("Test getObject()")
  void testGetObject() {
    // Arrange and Act
    COSBase actualObject = (new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))).getObject();

    // Assert
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Test {@link COSObject#setToNull()}.
   * <p>
   * Method under test: {@link COSObject#setToNull()}
   */
  @Test
  @DisplayName("Test setToNull()")
  void testSetToNull() {
    // Arrange
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    cosObject.setToNull();

    // Assert
    COSBase object = cosObject.getObject();
    assertTrue(object instanceof COSNull);
    assertNull(object.getKey());
    assertFalse(object.isDirect());
    assertFalse(cosObject.isObjectNull());
  }

  /**
   * Test {@link COSObject#setToNull()}.
   * <p>
   * Method under test: {@link COSObject#setToNull()}
   */
  @Test
  @DisplayName("Test setToNull()")
  void testSetToNull2() {
    // Arrange
    COSObject cosObject = new COSObject(null, new COSObjectKey(1L, 1));

    // Act
    cosObject.setToNull();

    // Assert
    COSBase object = cosObject.getObject();
    assertTrue(object instanceof COSNull);
    assertNull(object.getKey());
    assertFalse(object.isDirect());
    assertFalse(cosObject.isObjectNull());
  }

  /**
   * Test {@link COSObject#accept(ICOSVisitor)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#accept(ICOSVisitor)} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSObject#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); given COSArray accept(ICOSVisitor) throw IOException(String) with 'foo'; then throw IOException")
  void testAccept_givenCOSArrayAcceptThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    COSArray object = mock(COSArray.class);
    doThrow(new IOException("foo")).when(object).accept(Mockito.<ICOSVisitor>any());
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act and Assert
    assertThrows(IOException.class, () -> cosObject.accept(new COSWriter(new ByteArrayOutputStream(1))));
    verify(object).accept(isA(ICOSVisitor.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link COSObject#toString()}
   *   <li>{@link COSObject#getUpdateState()}
   *   <li>{@link COSObject#isDereferenced()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    String actualToStringResult = cosObject.toString();
    COSUpdateState actualUpdateState = cosObject.getUpdateState();
    boolean actualIsDereferencedResult = cosObject.isDereferenced();

    // Assert
    assertEquals("COSObject{1 1 R}", actualToStringResult);
    assertNull(actualUpdateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualUpdateState.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualUpdateState.isAcceptingUpdates());
    assertFalse(actualUpdateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualIsDereferencedResult);
  }
}
