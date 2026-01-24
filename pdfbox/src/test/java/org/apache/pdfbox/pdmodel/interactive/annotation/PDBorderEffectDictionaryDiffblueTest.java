package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDBorderEffectDictionaryDiffblueTest {
  /**
   * Test {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#PDBorderEffectDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDBorderEffectDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderEffectDictionary.<init>(COSDictionary)"})
  void testNewPDBorderEffectDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDBorderEffectDictionary(dict).getCOSObject());
  }

  /**
   * Test {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}
   */
  @Test
  @DisplayName("Test new PDBorderEffectDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderEffectDictionary.<init>()"})
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
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDBorderEffectDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDBorderEffectDictionary().getCOSObject();

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
   *
   * <ul>
   *   <li>Then {@link PDBorderEffectDictionary#PDBorderEffectDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#setIntensity(float)}
   */
  @Test
  @DisplayName(
      "Test setIntensity(float); then PDBorderEffectDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderEffectDictionary.setIntensity(float)"})
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
   *
   * <ul>
   *   <li>Given {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#getIntensity()}
   */
  @Test
  @DisplayName("Test getIntensity(); given PDBorderEffectDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDBorderEffectDictionary.getIntensity()"})
  void testGetIntensity_givenPDBorderEffectDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDBorderEffectDictionary().getIntensity());
  }

  /**
   * Test {@link PDBorderEffectDictionary#setStyle(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDBorderEffectDictionary#PDBorderEffectDictionary()} Style is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#setStyle(String)}
   */
  @Test
  @DisplayName("Test setStyle(String); when '42'; then PDBorderEffectDictionary() Style is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderEffectDictionary.setStyle(String)"})
  void testSetStyle_when42_thenPDBorderEffectDictionaryStyleIs42() {
    // Arrange
    PDBorderEffectDictionary pdBorderEffectDictionary = new PDBorderEffectDictionary();

    // Act
    pdBorderEffectDictionary.setStyle("42");

    // Assert
    assertEquals("42", pdBorderEffectDictionary.getStyle());
    COSDictionary cOSObject = pdBorderEffectDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDBorderEffectDictionary#setStyle(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDBorderEffectDictionary#PDBorderEffectDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#setStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStyle(String); when 'null'; then PDBorderEffectDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderEffectDictionary.setStyle(String)"})
  void testSetStyle_whenNull_thenPDBorderEffectDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDBorderEffectDictionary pdBorderEffectDictionary = new PDBorderEffectDictionary();

    // Act
    pdBorderEffectDictionary.setStyle(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdBorderEffectDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, pdBorderEffectDictionary.getStyle());
  }

  /**
   * Test {@link PDBorderEffectDictionary#setStyle(String)}.
   *
   * <ul>
   *   <li>When {@code Style}.
   *   <li>Then {@link PDBorderEffectDictionary#PDBorderEffectDictionary()} Style is {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#setStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStyle(String); when 'Style'; then PDBorderEffectDictionary() Style is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBorderEffectDictionary.setStyle(String)"})
  void testSetStyle_whenStyle_thenPDBorderEffectDictionaryStyleIsStyle() {
    // Arrange
    PDBorderEffectDictionary pdBorderEffectDictionary = new PDBorderEffectDictionary();

    // Act
    pdBorderEffectDictionary.setStyle("Style");

    // Assert
    assertEquals("Style", pdBorderEffectDictionary.getStyle());
    COSDictionary cOSObject = pdBorderEffectDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDBorderEffectDictionary#getStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   *   <li>Then return {@link PDBorderEffectDictionary#STYLE_SOLID}.
   * </ul>
   *
   * <p>Method under test: {@link PDBorderEffectDictionary#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDBorderEffectDictionary(); then return STYLE_SOLID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDBorderEffectDictionary.getStyle()"})
  void testGetStyle_givenPDBorderEffectDictionary_thenReturnStyle_solid() {
    // Arrange, Act and Assert
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, new PDBorderEffectDictionary().getStyle());
  }
}
