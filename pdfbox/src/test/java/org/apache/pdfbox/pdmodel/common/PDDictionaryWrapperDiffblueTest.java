package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDDictionaryWrapperDiffblueTest {
  /**
   * Test {@link PDDictionaryWrapper#PDDictionaryWrapper(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDDictionaryWrapper#PDDictionaryWrapper(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDictionaryWrapper(COSDictionary)")
  void testNewPDDictionaryWrapper() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDDictionaryWrapper(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDDictionaryWrapper#PDDictionaryWrapper()}.
   * <p>
   * Method under test: {@link PDDictionaryWrapper#PDDictionaryWrapper()}
   */
  @Test
  @DisplayName("Test new PDDictionaryWrapper()")
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

  /**
   * Test {@link PDDictionaryWrapper#getCOSObject()}.
   * <p>
   * Method under test: {@link PDDictionaryWrapper#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link PDDictionaryWrapper#equals(Object)}, and
   * {@link PDDictionaryWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDDictionaryWrapper#equals(Object)}
   *   <li>{@link PDDictionaryWrapper#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDDictionaryWrapper pdDictionaryWrapper = new PDDictionaryWrapper();

    // Act and Assert
    assertEquals(pdDictionaryWrapper, pdDictionaryWrapper);
    int expectedHashCodeResult = pdDictionaryWrapper.hashCode();
    assertEquals(expectedHashCodeResult, pdDictionaryWrapper.hashCode());
  }

  /**
   * Test {@link PDDictionaryWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDDictionaryWrapper pdDictionaryWrapper = new PDDictionaryWrapper();

    // Act and Assert
    assertNotEquals(pdDictionaryWrapper, new PDDictionaryWrapper());
  }

  /**
   * Test {@link PDDictionaryWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDDictionaryWrapper(), null);
  }

  /**
   * Test {@link PDDictionaryWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDictionaryWrapper#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDDictionaryWrapper(), "Different type to PDDictionaryWrapper");
  }
}
