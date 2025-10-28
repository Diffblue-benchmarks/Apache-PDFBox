package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDSeedValueTimeStampDiffblueTest {
  /**
   * Method under test: {@link PDSeedValueTimeStamp#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDSeedValueTimeStamp()).getCOSObject();

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
   * Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  void testGetURL() {
    // Arrange, Act and Assert
    assertNull((new PDSeedValueTimeStamp()).getURL());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  void testGetURL2() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("https://example.org/example");

    // Act and Assert
    assertEquals("https://example.org/example", pdSeedValueTimeStamp.getURL());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#getURL()}
   */
  @Test
  void testGetURL3() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setURL("");

    // Act and Assert
    assertEquals("", pdSeedValueTimeStamp.getURL());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#setURL(String)}
   */
  @Test
  void testSetURL() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", pdSeedValueTimeStamp.getURL());
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  void testIsTimestampRequired() {
    // Arrange, Act and Assert
    assertFalse((new PDSeedValueTimeStamp()).isTimestampRequired());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#isTimestampRequired()}
   */
  @Test
  void testIsTimestampRequired2() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();
    pdSeedValueTimeStamp.setTimestampRequired(true);

    // Act and Assert
    assertTrue(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}
   */
  @Test
  void testSetTimestampRequired() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setTimestampRequired(true);

    // Assert
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#setTimestampRequired(boolean)}
   */
  @Test
  void testSetTimestampRequired2() {
    // Arrange
    PDSeedValueTimeStamp pdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Act
    pdSeedValueTimeStamp.setTimestampRequired(false);

    // Assert
    COSDictionary cOSObject = pdSeedValueTimeStamp.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdSeedValueTimeStamp.isTimestampRequired());
  }

  /**
   * Method under test: {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp()}
   */
  @Test
  void testNewPDSeedValueTimeStamp() {
    // Arrange and Act
    PDSeedValueTimeStamp actualPdSeedValueTimeStamp = new PDSeedValueTimeStamp();

    // Assert
    assertNull(actualPdSeedValueTimeStamp.getURL());
    COSDictionary cOSObject = actualPdSeedValueTimeStamp.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdSeedValueTimeStamp.isTimestampRequired());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Method under test:
   * {@link PDSeedValueTimeStamp#PDSeedValueTimeStamp(COSDictionary)}
   */
  @Test
  void testNewPDSeedValueTimeStamp2() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValueTimeStamp actualPdSeedValueTimeStamp = new PDSeedValueTimeStamp(dict);

    // Assert
    assertNull(actualPdSeedValueTimeStamp.getURL());
    assertFalse(actualPdSeedValueTimeStamp.isTimestampRequired());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValueTimeStamp.getCOSObject());
  }
}
