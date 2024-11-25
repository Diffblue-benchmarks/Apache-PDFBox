package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDBorderEffectDictionaryDiffblueTest {
  /**
   * Test
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDBorderEffectDictionary(COSDictionary)")
  void testNewPDBorderEffectDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDBorderEffectDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   * <p>
   * Method under test:
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}
   */
  @Test
  @DisplayName("Test new PDBorderEffectDictionary()")
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

  /**
   * Test {@link PDBorderEffectDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
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
   * Test {@link PDBorderEffectDictionary#setIntensity(float)}.
   * <ul>
   *   <li>Then {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}
   * COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#setIntensity(float)}
   */
  @Test
  @DisplayName("Test setIntensity(float); then PDBorderEffectDictionary() COSObject Values size is one")
  void testSetIntensity_thenPDBorderEffectDictionaryCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDBorderEffectDictionary#getIntensity()}.
   * <ul>
   *   <li>Given
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)} with
   * dict is {@link COSStream#COSStream()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#getIntensity()}
   */
  @Test
  @DisplayName("Test getIntensity(); given PDBorderEffectDictionary(COSDictionary) with dict is COSStream(); then return zero")
  void testGetIntensity_givenPDBorderEffectDictionaryWithDictIsCOSStream_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDBorderEffectDictionary(new COSStream())).getIntensity());
  }

  /**
   * Test {@link PDBorderEffectDictionary#getIntensity()}.
   * <ul>
   *   <li>Given {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#getIntensity()}
   */
  @Test
  @DisplayName("Test getIntensity(); given PDBorderEffectDictionary(); then return zero")
  void testGetIntensity_givenPDBorderEffectDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDBorderEffectDictionary()).getIntensity());
  }

  /**
   * Test {@link PDBorderEffectDictionary#setStyle(String)}.
   * <ul>
   *   <li>Then {@link PDBorderEffectDictionary#PDBorderEffectDictionary()} Style is
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#setStyle(String)}
   */
  @Test
  @DisplayName("Test setStyle(String); then PDBorderEffectDictionary() Style is 'foo'")
  void testSetStyle_thenPDBorderEffectDictionaryStyleIsFoo() {
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
   * Test {@link PDBorderEffectDictionary#getStyle()}.
   * <ul>
   *   <li>Given
   * {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)} with
   * dict is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDBorderEffectDictionary(COSDictionary) with dict is COSStream()")
  void testGetStyle_givenPDBorderEffectDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, (new PDBorderEffectDictionary(new COSStream())).getStyle());
  }

  /**
   * Test {@link PDBorderEffectDictionary#getStyle()}.
   * <ul>
   *   <li>Given {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.</li>
   *   <li>Then return {@link PDBorderEffectDictionary#STYLE_SOLID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBorderEffectDictionary#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDBorderEffectDictionary(); then return STYLE_SOLID")
  void testGetStyle_givenPDBorderEffectDictionary_thenReturnStyle_solid() {
    // Arrange, Act and Assert
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, (new PDBorderEffectDictionary()).getStyle());
  }
}
