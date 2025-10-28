package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDBorderEffectDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDBorderEffectDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDBorderEffectDictionary()).getCOSObject();

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
   * Method under test: {@link PDBorderEffectDictionary#setIntensity(float)}
   */
  @Test
  void testSetIntensity() {
    // Arrange
    PDBorderEffectDictionary pdBorderEffectDictionary = new PDBorderEffectDictionary();

    // Act
    pdBorderEffectDictionary.setIntensity(10.0f);

    // Assert
    COSDictionary cOSObject = pdBorderEffectDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(10.0f, pdBorderEffectDictionary.getIntensity());
  }

  /**
   * Method under test: {@link PDBorderEffectDictionary#getIntensity()}
   */
  @Test
  void testGetIntensity() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDBorderEffectDictionary()).getIntensity());
  }

  /**
   * Method under test: {@link PDBorderEffectDictionary#setStyle(String)}
   */
  @Test
  void testSetStyle() {
    // Arrange
    PDBorderEffectDictionary pdBorderEffectDictionary = new PDBorderEffectDictionary();

    // Act
    pdBorderEffectDictionary.setStyle("foo");

    // Assert
    assertEquals("foo", pdBorderEffectDictionary.getStyle());
    COSDictionary cOSObject = pdBorderEffectDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDBorderEffectDictionary#getStyle()}
   */
  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, (new PDBorderEffectDictionary()).getStyle());
  }

  /**
   * Method under test:
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)}
   */
  @Test
  void testNewPDBorderEffectDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDBorderEffectDictionary(dict)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}
   */
  @Test
  void testNewPDBorderEffectDictionary2() {
    // Arrange and Act
    PDBorderEffectDictionary actualPdBorderEffectDictionary = new PDBorderEffectDictionary();

    // Assert
    COSDictionary cOSObject = actualPdBorderEffectDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertEquals(0.0f, actualPdBorderEffectDictionary.getIntensity());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, actualPdBorderEffectDictionary.getStyle());
  }
}
