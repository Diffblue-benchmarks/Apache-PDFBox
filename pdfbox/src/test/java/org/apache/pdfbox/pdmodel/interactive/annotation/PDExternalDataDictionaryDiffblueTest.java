package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDExternalDataDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDExternalDataDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDExternalDataDictionary()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDExternalDataDictionary#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("ExData", (new PDExternalDataDictionary()).getType());
    assertEquals("ExData", (new PDExternalDataDictionary(new COSDictionary())).getType());
  }

  /**
   * Method under test: {@link PDExternalDataDictionary#getSubtype()}
   */
  @Test
  void testGetSubtype() {
    // Arrange, Act and Assert
    assertNull((new PDExternalDataDictionary()).getSubtype());
  }

  /**
   * Method under test: {@link PDExternalDataDictionary#setSubtype(String)}
   */
  @Test
  void testSetSubtype() {
    // Arrange
    PDExternalDataDictionary pdExternalDataDictionary = new PDExternalDataDictionary();

    // Act
    pdExternalDataDictionary.setSubtype("Subtype");

    // Assert
    assertEquals("Subtype", pdExternalDataDictionary.getSubtype());
    COSDictionary cOSObject = pdExternalDataDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDExternalDataDictionary#setSubtype(String)}
   */
  @Test
  void testSetSubtype2() {
    // Arrange
    PDExternalDataDictionary pdExternalDataDictionary = new PDExternalDataDictionary();

    // Act
    pdExternalDataDictionary.setSubtype("42");

    // Assert
    assertEquals("42", pdExternalDataDictionary.getSubtype());
    COSDictionary cOSObject = pdExternalDataDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDExternalDataDictionary#PDExternalDataDictionary(COSDictionary)}
   */
  @Test
  void testNewPDExternalDataDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDExternalDataDictionary(dictionary)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDExternalDataDictionary#PDExternalDataDictionary()}
   */
  @Test
  void testNewPDExternalDataDictionary2() {
    // Arrange and Act
    PDExternalDataDictionary actualPdExternalDataDictionary = new PDExternalDataDictionary();

    // Assert
    assertEquals("ExData", actualPdExternalDataDictionary.getType());
    assertNull(actualPdExternalDataDictionary.getSubtype());
    COSDictionary cOSObject = actualPdExternalDataDictionary.getCOSObject();
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
