package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDListAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDListAttributeObject#getListNumbering()}
   */
  @Test
  void testGetListNumbering() {
    // Arrange, Act and Assert
    assertEquals(PDListAttributeObject.LIST_NUMBERING_NONE, (new PDListAttributeObject()).getListNumbering());
  }

  /**
   * Method under test: {@link PDListAttributeObject#setListNumbering(String)}
   */
  @Test
  void testSetListNumbering() {
    // Arrange
    PDListAttributeObject pdListAttributeObject = new PDListAttributeObject();

    // Act
    pdListAttributeObject.setListNumbering("42");

    // Assert
    assertEquals("42", pdListAttributeObject.getListNumbering());
    COSDictionary cOSObject = pdListAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdListAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDListAttributeObject#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("O=List", (new PDListAttributeObject()).toString());
  }

  /**
   * Method under test:
   * {@link PDListAttributeObject#PDListAttributeObject(COSDictionary)}
   */
  @Test
  void testNewPDListAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDListAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Method under test: {@link PDListAttributeObject#PDListAttributeObject()}
   */
  @Test
  void testNewPDListAttributeObject2() {
    // Arrange and Act
    PDListAttributeObject actualPdListAttributeObject = new PDListAttributeObject();

    // Assert
    COSDictionary cOSObject = actualPdListAttributeObject.getCOSObject();
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
    assertTrue(actualPdListAttributeObject.isEmpty());
    assertEquals(PDListAttributeObject.LIST_NUMBERING_NONE, actualPdListAttributeObject.getListNumbering());
    assertEquals(PDListAttributeObject.OWNER_LIST, actualPdListAttributeObject.getOwner());
  }
}
