package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSObjectDiffblueTest {
  /**
   * Test {@link COSObject#COSObject(COSBase)}.
   *
   * <p>Method under test: {@link COSObject#COSObject(COSBase)}
   */
  @Test
  @DisplayName("Test new COSObject(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSObject.<init>(COSBase)"})
  void testNewCOSObject() {
    // Arrange and Act
    COSObject actualCosObject = new COSObject(COSBoolean.FALSE);

    // Assert
    COSUpdateState updateState = actualCosObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosObject.getKey());
    COSIncrement toIncrementResult = actualCosObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCosObject.isDirect());
    assertFalse(actualCosObject.isObjectNull());
    assertFalse(actualCosObject.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCosObject.isDereferenced());
    assertSame(COSBoolean.FALSE, actualCosObject.getObject());
  }

  /**
   * Test {@link COSObject#COSObject(COSBase, COSObjectKey)}.
   *
   * <p>Method under test: {@link COSObject#COSObject(COSBase, COSObjectKey)}
   */
  @Test
  @DisplayName("Test new COSObject(COSBase, COSObjectKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSObject.<init>(COSBase, COSObjectKey)"})
  void testNewCOSObject2() {
    // Arrange
    COSObjectKey objectKey = new COSObjectKey(1L, 1);

    // Act
    COSObject actualCosObject = new COSObject(COSBoolean.FALSE, objectKey);

    // Assert
    COSUpdateState updateState = actualCosObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualCosObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCosObject.isDirect());
    assertFalse(actualCosObject.isObjectNull());
    assertFalse(actualCosObject.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCosObject.isDereferenced());
    assertSame(objectKey, actualCosObject.getKey());
    assertSame(COSBoolean.FALSE, actualCosObject.getObject());
  }

  /**
   * Test {@link COSObject#isObjectNull()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link COSObject#isObjectNull()}
   */
  @Test
  @DisplayName(
      "Test isObjectNull(); given COSObjectKey(long, int) with num is one and gen is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObject.isObjectNull()"})
  void testIsObjectNull_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnFalse() {
    // Arrange
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act and Assert
    assertFalse(cosObject.isObjectNull());
  }

  /**
   * Test {@link COSObject#isObjectNull()}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase)} with object is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSObject#isObjectNull()}
   */
  @Test
  @DisplayName(
      "Test isObjectNull(); given COSObject(COSBase) with object is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSObject.isObjectNull()"})
  void testIsObjectNull_givenCOSObjectWithObjectIsNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new COSObject(null).isObjectNull());
  }

  /**
   * Test {@link COSObject#getObject()}.
   *
   * <ul>
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSObject#getObject()}
   */
  @Test
  @DisplayName("Test getObject(); then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase COSObject.getObject()"})
  void testGetObject_thenReturnFalse() {
    // Arrange
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    COSBase actualObject = cosObject.getObject();

    // Assert
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSObject#toString()}
   *   <li>{@link COSObject#getUpdateState()}
   *   <li>{@link COSObject#isDereferenced()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSUpdateState COSObject.getUpdateState()",
    "boolean COSObject.isDereferenced()",
    "String COSObject.toString()"
  })
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
