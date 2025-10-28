package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDTypedDictionaryWrapperDiffblueTest {
  /**
   * Method under test: {@link PDTypedDictionaryWrapper#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Type", (new PDTypedDictionaryWrapper("Type")).getType());
    assertNull((new PDTypedDictionaryWrapper(new COSDictionary())).getType());
  }

  /**
   * Method under test:
   * {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(COSDictionary)}
   */
  @Test
  void testNewPDTypedDictionaryWrapper() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDTypedDictionaryWrapper(dictionary)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}
   */
  @Test
  void testNewPDTypedDictionaryWrapper2() {
    // Arrange and Act
    PDTypedDictionaryWrapper actualPdTypedDictionaryWrapper = new PDTypedDictionaryWrapper("Type");

    // Assert
    assertEquals("Type", actualPdTypedDictionaryWrapper.getType());
    COSDictionary cOSObject = actualPdTypedDictionaryWrapper.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}
   */
  @Test
  void testNewPDTypedDictionaryWrapper3() {
    // Arrange and Act
    PDTypedDictionaryWrapper actualPdTypedDictionaryWrapper = new PDTypedDictionaryWrapper((String) null);

    // Assert
    assertNull(actualPdTypedDictionaryWrapper.getType());
    COSDictionary cOSObject = actualPdTypedDictionaryWrapper.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDTypedDictionaryWrapper#PDTypedDictionaryWrapper(String)}
   */
  @Test
  void testNewPDTypedDictionaryWrapper4() {
    // Arrange and Act
    PDTypedDictionaryWrapper actualPdTypedDictionaryWrapper = new PDTypedDictionaryWrapper("42");

    // Assert
    assertEquals("42", actualPdTypedDictionaryWrapper.getType());
    COSDictionary cOSObject = actualPdTypedDictionaryWrapper.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
