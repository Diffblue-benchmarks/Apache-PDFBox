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

class PDActionJavaScriptDiffblueTest {
  /**
   * Method under test: {@link PDActionJavaScript#setAction(String)}
   */
  @Test
  void testSetAction() {
    // Arrange
    PDActionJavaScript pdActionJavaScript = new PDActionJavaScript();

    // Act
    pdActionJavaScript.setAction("S Action");

    // Assert
    assertEquals("S Action", pdActionJavaScript.getAction());
    COSDictionary cOSObject = pdActionJavaScript.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionJavaScript#getAction()}
   */
  @Test
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDActionJavaScript()).getAction());
    assertEquals("Js", (new PDActionJavaScript("Js")).getAction());
    assertEquals("", (new PDActionJavaScript("")).getAction());
  }

  /**
   * Method under test:
   * {@link PDActionJavaScript#PDActionJavaScript(COSDictionary)}
   */
  @Test
  void testNewPDActionJavaScript() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionJavaScript(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionJavaScript#PDActionJavaScript()}
   */
  @Test
  void testNewPDActionJavaScript2() {
    // Arrange and Act
    PDActionJavaScript actualPdActionJavaScript = new PDActionJavaScript();

    // Assert
    assertNull(actualPdActionJavaScript.getAction());
    assertNull(actualPdActionJavaScript.getNext());
    COSDictionary cOSObject = actualPdActionJavaScript.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPdActionJavaScript.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPdActionJavaScript.getSubType());
  }

  /**
   * Method under test: {@link PDActionJavaScript#PDActionJavaScript(String)}
   */
  @Test
  void testNewPDActionJavaScript3() {
    // Arrange and Act
    PDActionJavaScript actualPdActionJavaScript = new PDActionJavaScript("Js");

    // Assert
    assertEquals("Js", actualPdActionJavaScript.getAction());
    assertNull(actualPdActionJavaScript.getNext());
    COSDictionary cOSObject = actualPdActionJavaScript.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionJavaScript.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPdActionJavaScript.getSubType());
  }

  /**
   * Method under test: {@link PDActionJavaScript#PDActionJavaScript(String)}
   */
  @Test
  void testNewPDActionJavaScript4() {
    // Arrange and Act
    PDActionJavaScript actualPdActionJavaScript = new PDActionJavaScript((String) null);

    // Assert
    assertNull(actualPdActionJavaScript.getAction());
    assertNull(actualPdActionJavaScript.getNext());
    COSDictionary cOSObject = actualPdActionJavaScript.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPdActionJavaScript.getType());
    assertEquals(PDActionJavaScript.SUB_TYPE, actualPdActionJavaScript.getSubType());
  }
}
