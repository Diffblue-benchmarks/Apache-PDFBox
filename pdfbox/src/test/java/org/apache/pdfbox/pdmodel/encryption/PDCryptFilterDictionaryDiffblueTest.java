package org.apache.pdfbox.pdmodel.encryption;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDCryptFilterDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDCryptFilterDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act and Assert
    assertSame(pdCryptFilterDictionary.cryptFilterDictionary, pdCryptFilterDictionary.getCOSObject());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#setLength(int)}
   */
  @Test
  void testSetLength() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setLength(3);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(3, pdCryptFilterDictionary.getLength());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#setLength(int)}
   */
  @Test
  void testSetLength2() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setLength(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdCryptFilterDictionary.getLength());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#getLength()}
   */
  @Test
  void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(PDEncryption.DEFAULT_LENGTH, (new PDCryptFilterDictionary()).getLength());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#getLength()}
   */
  @Test
  void testGetLength2() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setLength(3);

    // Act and Assert
    assertEquals(3, pdCryptFilterDictionary.getLength());
  }

  /**
   * Method under test:
   * {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}
   */
  @Test
  void testSetCryptFilterMethod() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    COSName cfm = COSName.A;

    // Act
    pdCryptFilterDictionary.setCryptFilterMethod(cfm);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSName expectedCryptFilterMethod = cfm.A;
    assertSame(expectedCryptFilterMethod, pdCryptFilterDictionary.getCryptFilterMethod());
  }

  /**
   * Method under test:
   * {@link PDCryptFilterDictionary#setCryptFilterMethod(COSName)}
   */
  @Test
  void testSetCryptFilterMethod2() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setCryptFilterMethod(null);

    // Assert
    assertNull(pdCryptFilterDictionary.getCryptFilterMethod());
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  void testGetCryptFilterMethod() {
    // Arrange, Act and Assert
    assertNull((new PDCryptFilterDictionary()).getCryptFilterMethod());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#getCryptFilterMethod()}
   */
  @Test
  void testGetCryptFilterMethod2() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();
    pdCryptFilterDictionary.setCryptFilterMethod(COSName.A);

    // Act
    COSName actualCryptFilterMethod = pdCryptFilterDictionary.getCryptFilterMethod();

    // Assert
    assertSame(actualCryptFilterMethod.A, actualCryptFilterMethod);
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#isEncryptMetaData()}
   */
  @Test
  void testIsEncryptMetaData() {
    // Arrange, Act and Assert
    assertTrue((new PDCryptFilterDictionary()).isEncryptMetaData());
  }

  /**
   * Method under test:
   * {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}
   */
  @Test
  void testSetEncryptMetaData() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setEncryptMetaData(true);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdCryptFilterDictionary.isEncryptMetaData());
  }

  /**
   * Method under test:
   * {@link PDCryptFilterDictionary#setEncryptMetaData(boolean)}
   */
  @Test
  void testSetEncryptMetaData2() {
    // Arrange
    PDCryptFilterDictionary pdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Act
    pdCryptFilterDictionary.setEncryptMetaData(false);

    // Assert
    COSDictionary cOSObject = pdCryptFilterDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdCryptFilterDictionary.isEncryptMetaData());
  }

  /**
   * Method under test:
   * {@link PDCryptFilterDictionary#PDCryptFilterDictionary(COSDictionary)}
   */
  @Test
  void testNewPDCryptFilterDictionary() {
    // Arrange
    COSDictionary d = new COSDictionary();

    // Act and Assert
    assertSame(d, (new PDCryptFilterDictionary(d)).getCOSObject());
  }

  /**
   * Method under test: {@link PDCryptFilterDictionary#PDCryptFilterDictionary()}
   */
  @Test
  void testNewPDCryptFilterDictionary2() {
    // Arrange and Act
    PDCryptFilterDictionary actualPdCryptFilterDictionary = new PDCryptFilterDictionary();

    // Assert
    COSDictionary cOSObject = actualPdCryptFilterDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdCryptFilterDictionary.getCryptFilterMethod());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdCryptFilterDictionary.isEncryptMetaData());
    assertEquals(PDEncryption.DEFAULT_LENGTH, actualPdCryptFilterDictionary.getLength());
  }
}
