package org.apache.pdfbox.pdmodel.fdf;

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

class FDFPageInfoDiffblueTest {
  /**
   * Test {@link FDFPageInfo#FDFPageInfo(COSDictionary)}.
   * <p>
   * Method under test: {@link FDFPageInfo#FDFPageInfo(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FDFPageInfo(COSDictionary)")
  void testNewFDFPageInfo() {
    // Arrange
    COSDictionary p = new COSDictionary();

    // Act and Assert
    assertSame(p, (new FDFPageInfo(p)).getCOSObject());
  }

  /**
   * Test {@link FDFPageInfo#FDFPageInfo()}.
   * <p>
   * Method under test: {@link FDFPageInfo#FDFPageInfo()}
   */
  @Test
  @DisplayName("Test new FDFPageInfo()")
  void testNewFDFPageInfo2() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFPageInfo()).getCOSObject();

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
   * Test {@link FDFPageInfo#getCOSObject()}.
   * <p>
   * Method under test: {@link FDFPageInfo#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new FDFPageInfo()).getCOSObject();

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
