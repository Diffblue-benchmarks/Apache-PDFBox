package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDListAttributeObjectDiffblueTest {
  /**
   * Test {@link PDListAttributeObject#PDListAttributeObject(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDListAttributeObject#PDListAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDListAttributeObject(COSDictionary)")
  void testNewPDListAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDListAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDListAttributeObject#PDListAttributeObject()}.
   * <p>
   * Method under test: {@link PDListAttributeObject#PDListAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDListAttributeObject()")
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

  /**
   * Test {@link PDListAttributeObject#getListNumbering()}.
   * <ul>
   *   <li>Given {@link PDListAttributeObject#PDListAttributeObject()}.</li>
   *   <li>Then return {@link PDListAttributeObject#LIST_NUMBERING_NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListAttributeObject#getListNumbering()}
   */
  @Test
  @DisplayName("Test getListNumbering(); given PDListAttributeObject(); then return LIST_NUMBERING_NONE")
  void testGetListNumbering_givenPDListAttributeObject_thenReturnList_numbering_none() {
    // Arrange, Act and Assert
    assertEquals(PDListAttributeObject.LIST_NUMBERING_NONE, (new PDListAttributeObject()).getListNumbering());
  }

  /**
   * Test {@link PDListAttributeObject#setListNumbering(String)}.
   * <ul>
   *   <li>Then {@link PDListAttributeObject#PDListAttributeObject()} ListNumbering
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListAttributeObject#setListNumbering(String)}
   */
  @Test
  @DisplayName("Test setListNumbering(String); then PDListAttributeObject() ListNumbering is '42'")
  void testSetListNumbering_thenPDListAttributeObjectListNumberingIs42() {
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
   * Test {@link PDListAttributeObject#toString()}.
   * <ul>
   *   <li>Given {@link PDListAttributeObject#PDListAttributeObject()}.</li>
   *   <li>Then return {@code O=List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDListAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDListAttributeObject(); then return 'O=List'")
  void testToString_givenPDListAttributeObject_thenReturnOList() {
    // Arrange, Act and Assert
    assertEquals("O=List", (new PDListAttributeObject()).toString());
  }
}
