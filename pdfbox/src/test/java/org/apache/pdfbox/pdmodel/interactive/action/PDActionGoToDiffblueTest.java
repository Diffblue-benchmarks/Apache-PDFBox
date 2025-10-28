package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDNamedDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.junit.jupiter.api.Test;

class PDActionGoToDiffblueTest {
  /**
   * Method under test: {@link PDActionGoTo#PDActionGoTo(COSDictionary)}
   */
  @Test
  void testNewPDActionGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionGoTo(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination() throws IOException {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act
    pdActionGoTo.setDestination(new PDNamedDestination("Dest"));

    // Assert
    PDDestination destination = pdActionGoTo.getDestination();
    assertTrue(destination instanceof PDNamedDestination);
    assertEquals("Dest", ((PDNamedDestination) destination).getNamedDestination());
    COSDictionary cOSObject = pdActionGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination2() {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdActionGoTo.setDestination(new PDPageFitDestination()));
  }

  /**
   * Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination3() {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act
    pdActionGoTo.setDestination(new PDPageFitDestination(new COSArray()));

    // Assert
    COSDictionary cOSObject = pdActionGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionGoTo#setDestination(PDDestination)}
   */
  @Test
  void testSetDestination4() throws IOException {
    // Arrange
    PDActionGoTo pdActionGoTo = new PDActionGoTo();

    // Act
    pdActionGoTo.setDestination(null);

    // Assert
    assertNull(pdActionGoTo.getDestination());
    COSDictionary cOSObject = pdActionGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionGoTo#PDActionGoTo()}
   */
  @Test
  void testNewPDActionGoTo2() throws IOException {
    // Arrange and Act
    PDActionGoTo actualPdActionGoTo = new PDActionGoTo();

    // Assert
    assertNull(actualPdActionGoTo.getNext());
    COSDictionary cOSObject = actualPdActionGoTo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionGoTo.getDestination());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionGoTo.getType());
    assertEquals(PDActionGoTo.SUB_TYPE, actualPdActionGoTo.getSubType());
  }
}
