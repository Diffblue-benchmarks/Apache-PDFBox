package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDDictionaryWrapperDiffblueTest {
  /**
   * Method under test: {@link PDDictionaryWrapper#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDDictionaryWrapper()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDictionaryWrapper#equals(Object)}
   *   <li>{@link PDDictionaryWrapper#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDDictionaryWrapper pdDictionaryWrapper = new PDDictionaryWrapper();

    // Act and Assert
    assertEquals(pdDictionaryWrapper, pdDictionaryWrapper);
    int expectedHashCodeResult = pdDictionaryWrapper.hashCode();
    assertEquals(expectedHashCodeResult, pdDictionaryWrapper.hashCode());
  }

  /**
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDDictionaryWrapper pdDictionaryWrapper = new PDDictionaryWrapper();

    // Act and Assert
    assertNotEquals(pdDictionaryWrapper, new PDDictionaryWrapper());
  }

  /**
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PDDictionaryWrapper(), mock(PDTypedDictionaryWrapper.class));
  }

  /**
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDDictionaryWrapper(), null);
  }

  /**
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDDictionaryWrapper(), "Different type to PDDictionaryWrapper");
  }

  /**
   * Method under test:
   * {@link PDDictionaryWrapper#PDDictionaryWrapper(COSDictionary)}
   */
  @Test
  void testNewPDDictionaryWrapper() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDDictionaryWrapper(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDDictionaryWrapper#PDDictionaryWrapper()}
   */
  @Test
  void testNewPDDictionaryWrapper2() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDDictionaryWrapper()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
