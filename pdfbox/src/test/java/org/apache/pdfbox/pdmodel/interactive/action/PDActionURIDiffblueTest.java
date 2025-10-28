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

class PDActionURIDiffblueTest {
  /**
   * Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  void testGetURI() {
    // Arrange, Act and Assert
    assertNull((new PDActionURI()).getURI());
  }

  /**
   * Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  void testGetURI2() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setURI("Uri");

    // Act and Assert
    assertEquals("Uri", pdActionURI.getURI());
  }

  /**
   * Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  void testGetURI3() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setURI("");

    // Act and Assert
    assertEquals("", pdActionURI.getURI());
  }

  /**
   * Method under test: {@link PDActionURI#setURI(String)}
   */
  @Test
  void testSetURI() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setURI("Uri");

    // Assert
    assertEquals("Uri", pdActionURI.getURI());
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  void testShouldTrackMousePosition() {
    // Arrange, Act and Assert
    assertFalse((new PDActionURI()).shouldTrackMousePosition());
  }

  /**
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  void testShouldTrackMousePosition2() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setTrackMousePosition(true);

    // Act and Assert
    assertTrue(pdActionURI.shouldTrackMousePosition());
  }

  /**
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  void testShouldTrackMousePosition3() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setTrackMousePosition(false);

    // Act and Assert
    assertFalse(pdActionURI.shouldTrackMousePosition());
  }

  /**
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  void testShouldTrackMousePosition4() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setURI("IsMapUri");

    // Act and Assert
    assertFalse(pdActionURI.shouldTrackMousePosition());
  }

  /**
   * Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  void testSetTrackMousePosition() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setTrackMousePosition(true);

    // Assert
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  void testSetTrackMousePosition2() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setTrackMousePosition(false);

    // Assert
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  void testSetTrackMousePosition3() {
    // Arrange
    COSDictionary a = new COSDictionary();

    PDActionURI pdActionURI = new PDActionURI(a);
    pdActionURI.setSubType("foo");

    // Act
    pdActionURI.setTrackMousePosition(true);

    // Assert
    assertSame(a, pdActionURI.getCOSObject());
  }

  /**
   * Method under test: {@link PDActionURI#PDActionURI(COSDictionary)}
   */
  @Test
  void testNewPDActionURI() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionURI(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionURI#PDActionURI()}
   */
  @Test
  void testNewPDActionURI2() {
    // Arrange and Act
    PDActionURI actualPdActionURI = new PDActionURI();

    // Assert
    assertNull(actualPdActionURI.getURI());
    assertNull(actualPdActionURI.getNext());
    COSDictionary cOSObject = actualPdActionURI.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionURI.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualPdActionURI.getSubType());
  }
}
