package org.apache.pdfbox.pdmodel.documentinterchange.markedcontent;

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

class PDPropertyListDiffblueTest {
  /**
   * Test {@link PDPropertyList#create(COSDictionary)}.
   * <p>
   * Method under test: {@link PDPropertyList#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary)")
  void testCreate() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, PDPropertyList.create(dict).getCOSObject());
  }

  /**
   * Test {@link PDPropertyList#PDPropertyList(COSDictionary)}.
   * <p>
   * Method under test: {@link PDPropertyList#PDPropertyList(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPropertyList(COSDictionary)")
  void testNewPDPropertyList() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDPropertyList(dict)).getCOSObject());
  }

  /**
   * Test {@link PDPropertyList#PDPropertyList()}.
   * <p>
   * Method under test: {@link PDPropertyList#PDPropertyList()}
   */
  @Test
  @DisplayName("Test new PDPropertyList()")
  void testNewPDPropertyList2() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDPropertyList()).getCOSObject();

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
   * Test {@link PDPropertyList#getCOSObject()}.
   * <p>
   * Method under test: {@link PDPropertyList#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    PDPropertyList pdPropertyList = new PDPropertyList();

    // Act and Assert
    assertSame(pdPropertyList.dict, pdPropertyList.getCOSObject());
  }
}
