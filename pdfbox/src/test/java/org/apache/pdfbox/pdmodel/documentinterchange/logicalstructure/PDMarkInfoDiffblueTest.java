package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDMarkInfoDiffblueTest {
  /**
   * Method under test: {@link PDMarkInfo#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDMarkInfo()).getCOSObject();

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
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  void testIsMarked() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo()).isMarked());
    assertFalse((new PDMarkInfo(new COSDictionary())).isMarked());
  }

  /**
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  void testIsMarked2() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setMarked(true);

    // Act and Assert
    assertTrue(pdMarkInfo.isMarked());
  }

  /**
   * Method under test: {@link PDMarkInfo#isMarked()}
   */
  @Test
  void testIsMarked3() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setMarked(false);

    // Act and Assert
    assertFalse(pdMarkInfo.isMarked());
  }

  /**
   * Method under test: {@link PDMarkInfo#setMarked(boolean)}
   */
  @Test
  void testSetMarked() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setMarked(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdMarkInfo.isMarked());
  }

  /**
   * Method under test: {@link PDMarkInfo#setMarked(boolean)}
   */
  @Test
  void testSetMarked2() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setMarked(false);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdMarkInfo.isMarked());
  }

  /**
   * Method under test: {@link PDMarkInfo#usesUserProperties()}
   */
  @Test
  void testUsesUserProperties() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo()).usesUserProperties());
  }

  /**
   * Method under test: {@link PDMarkInfo#usesUserProperties()}
   */
  @Test
  void testUsesUserProperties2() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setUserProperties(true);

    // Act and Assert
    assertTrue(pdMarkInfo.usesUserProperties());
  }

  /**
   * Method under test: {@link PDMarkInfo#usesUserProperties()}
   */
  @Test
  void testUsesUserProperties3() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setUserProperties(false);

    // Act and Assert
    assertFalse(pdMarkInfo.usesUserProperties());
  }

  /**
   * Method under test: {@link PDMarkInfo#setUserProperties(boolean)}
   */
  @Test
  void testSetUserProperties() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setUserProperties(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDMarkInfo#setUserProperties(boolean)}
   */
  @Test
  void testSetUserProperties2() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setUserProperties(false);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDMarkInfo#isSuspect()}
   */
  @Test
  void testIsSuspect() {
    // Arrange, Act and Assert
    assertFalse((new PDMarkInfo()).isSuspect());
  }

  /**
   * Method under test: {@link PDMarkInfo#isSuspect()}
   */
  @Test
  void testIsSuspect2() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();
    pdMarkInfo.setSuspect(true);

    // Act and Assert
    assertFalse(pdMarkInfo.isSuspect());
  }

  /**
   * Method under test: {@link PDMarkInfo#setSuspect(boolean)}
   */
  @Test
  void testSetSuspect() {
    // Arrange
    PDMarkInfo pdMarkInfo = new PDMarkInfo();

    // Act
    pdMarkInfo.setSuspect(true);

    // Assert
    COSDictionary cOSObject = pdMarkInfo.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDMarkInfo#PDMarkInfo(COSDictionary)}
   */
  @Test
  void testNewPDMarkInfo() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDMarkInfo(dic)).getCOSObject());
  }

  /**
   * Method under test: {@link PDMarkInfo#PDMarkInfo()}
   */
  @Test
  void testNewPDMarkInfo2() {
    // Arrange and Act
    PDMarkInfo actualPdMarkInfo = new PDMarkInfo();

    // Assert
    COSDictionary cOSObject = actualPdMarkInfo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdMarkInfo.isMarked());
    assertFalse(actualPdMarkInfo.isSuspect());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
