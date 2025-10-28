package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDSeedValueMDPDiffblueTest {
  /**
   * Method under test: {@link PDSeedValueMDP#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSeedValueMDP()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCOSObject.isDirect());
  }

  /**
   * Method under test: {@link PDSeedValueMDP#getP()}
   */
  @Test
  void testGetP() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDSeedValueMDP()).getP());
  }

  /**
   * Method under test: {@link PDSeedValueMDP#getP()}
   */
  @Test
  void testGetP2() {
    // Arrange
    PDSeedValueMDP pdSeedValueMDP = new PDSeedValueMDP();
    pdSeedValueMDP.setP(1);

    // Act and Assert
    assertEquals(1, pdSeedValueMDP.getP());
  }

  /**
   * Method under test: {@link PDSeedValueMDP#setP(int)}
   */
  @Test
  void testSetP() {
    // Arrange
    PDSeedValueMDP pdSeedValueMDP = new PDSeedValueMDP();

    // Act
    pdSeedValueMDP.setP(1);

    // Assert
    COSDictionary cOSObject = pdSeedValueMDP.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdSeedValueMDP.getP());
  }

  /**
   * Method under test: {@link PDSeedValueMDP#setP(int)}
   */
  @Test
  void testSetP2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDSeedValueMDP()).setP(-100));
  }

  /**
   * Method under test: {@link PDSeedValueMDP#setP(int)}
   */
  @Test
  void testSetP3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDSeedValueMDP()).setP(256));
  }

  /**
   * Method under test: {@link PDSeedValueMDP#PDSeedValueMDP()}
   */
  @Test
  void testNewPDSeedValueMDP() {
    // Arrange and Act
    PDSeedValueMDP actualPdSeedValueMDP = new PDSeedValueMDP();

    // Assert
    COSDictionary cOSObject = actualPdSeedValueMDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1, actualPdSeedValueMDP.getP());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Method under test: {@link PDSeedValueMDP#PDSeedValueMDP(COSDictionary)}
   */
  @Test
  void testNewPDSeedValueMDP2() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValueMDP actualPdSeedValueMDP = new PDSeedValueMDP(dict);

    // Assert
    assertEquals(-1, actualPdSeedValueMDP.getP());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValueMDP.getCOSObject());
  }
}
