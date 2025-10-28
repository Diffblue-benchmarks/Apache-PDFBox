package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDURIDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDURIDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDURIDictionary()).getCOSObject();

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
   * Method under test: {@link PDURIDictionary#getBase()}
   */
  @Test
  void testGetBase() {
    // Arrange, Act and Assert
    assertNull((new PDURIDictionary()).getBase());
  }

  /**
   * Method under test: {@link PDURIDictionary#setBase(String)}
   */
  @Test
  void testSetBase() {
    // Arrange
    PDURIDictionary pduriDictionary = new PDURIDictionary();

    // Act
    pduriDictionary.setBase("Base");

    // Assert
    assertEquals("Base", pduriDictionary.getBase());
    COSDictionary cOSObject = pduriDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDURIDictionary#PDURIDictionary(COSDictionary)}
   */
  @Test
  void testNewPDURIDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDURIDictionary(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDURIDictionary#PDURIDictionary()}
   */
  @Test
  void testNewPDURIDictionary2() {
    // Arrange and Act
    PDURIDictionary actualPduriDictionary = new PDURIDictionary();

    // Assert
    assertNull(actualPduriDictionary.getBase());
    COSDictionary cOSObject = actualPduriDictionary.getCOSObject();
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
}
