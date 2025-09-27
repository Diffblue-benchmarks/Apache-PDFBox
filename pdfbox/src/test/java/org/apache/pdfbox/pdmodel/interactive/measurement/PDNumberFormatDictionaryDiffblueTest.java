package org.apache.pdfbox.pdmodel.interactive.measurement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDNumberFormatDictionaryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDNumberFormatDictionary#PDNumberFormatDictionary(COSDictionary)}
   *   <li>{@link PDNumberFormatDictionary#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDNumberFormatDictionary.<init>(COSDictionary)",
    "String PDNumberFormatDictionary.getType()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDNumberFormatDictionary actualPdNumberFormatDictionary =
        new PDNumberFormatDictionary(dictionary);

    // Assert
    assertEquals(PDNumberFormatDictionary.TYPE, actualPdNumberFormatDictionary.getType());
    assertSame(dictionary, actualPdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}
   */
  @Test
  @DisplayName("Test new PDNumberFormatDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.<init>()"})
  void testNewPDNumberFormatDictionary() {
    // Arrange and Act
    PDNumberFormatDictionary actualPdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Assert
    assertEquals(" ", actualPdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", actualPdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", actualPdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", actualPdNumberFormatDictionary.getDecimalSeparator());
    assertNull(actualPdNumberFormatDictionary.getUnits());
    assertEquals(-1, actualPdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, actualPdNumberFormatDictionary.getConversionFactor());
    assertFalse(actualPdNumberFormatDictionary.isFD());
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL,
        actualPdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(
        PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE,
        actualPdNumberFormatDictionary.getLabelPositionToValue());
    assertEquals(PDNumberFormatDictionary.TYPE, actualPdNumberFormatDictionary.getType());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDNumberFormatDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDNumberFormatDictionary().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getUnits()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getUnits()}
   */
  @Test
  @DisplayName("Test getUnits(); given PDNumberFormatDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getUnits()"})
  void testGetUnits_givenPDNumberFormatDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDNumberFormatDictionary().getUnits());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setUnits(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} Units is {@code Units}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setUnits(String)}
   */
  @Test
  @DisplayName("Test setUnits(String); then PDNumberFormatDictionary() Units is 'Units'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setUnits(String)"})
  void testSetUnits_thenPDNumberFormatDictionaryUnitsIsUnits() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setUnits("Units");

    // Assert
    assertEquals("Units", pdNumberFormatDictionary.getUnits());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setUnits(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setUnits(String)}
   */
  @Test
  @DisplayName(
      "Test setUnits(String); when 'null'; then PDNumberFormatDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setUnits(String)"})
  void testSetUnits_whenNull_thenPDNumberFormatDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setUnits(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getConversionFactor()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getConversionFactor()}
   */
  @Test
  @DisplayName(
      "Test getConversionFactor(); given PDNumberFormatDictionary(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDNumberFormatDictionary.getConversionFactor()"})
  void testGetConversionFactor_givenPDNumberFormatDictionary_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new PDNumberFormatDictionary().getConversionFactor());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setConversionFactor(float)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} ConversionFactor is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setConversionFactor(float)}
   */
  @Test
  @DisplayName(
      "Test setConversionFactor(float); then PDNumberFormatDictionary() ConversionFactor is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setConversionFactor(float)"})
  void testSetConversionFactor_thenPDNumberFormatDictionaryConversionFactorIsTen() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setConversionFactor(10.0f);

    // Assert
    assertEquals(10.0f, pdNumberFormatDictionary.getConversionFactor());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getFractionalDisplay()}.
   *
   * <ul>
   *   <li>Then return {@link PDNumberFormatDictionary#FRACTIONAL_DISPLAY_DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getFractionalDisplay()}
   */
  @Test
  @DisplayName("Test getFractionalDisplay(); then return FRACTIONAL_DISPLAY_DECIMAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getFractionalDisplay()"})
  void testGetFractionalDisplay_thenReturnFractional_display_decimal() {
    // Arrange, Act and Assert
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL,
        new PDNumberFormatDictionary().getFractionalDisplay());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFractionalDisplay(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFractionalDisplay(String)}
   */
  @Test
  @DisplayName("Test setFractionalDisplay(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFractionalDisplay(String)"})
  void testSetFractionalDisplay() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFractionalDisplay(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_FRACTION,
        pdNumberFormatDictionary.getFractionalDisplay());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFractionalDisplay(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFractionalDisplay(String)}
   */
  @Test
  @DisplayName("Test setFractionalDisplay(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFractionalDisplay(String)"})
  void testSetFractionalDisplay2() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFractionalDisplay(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_ROUND);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_ROUND,
        pdNumberFormatDictionary.getFractionalDisplay());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFractionalDisplay(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFractionalDisplay(String)}
   */
  @Test
  @DisplayName("Test setFractionalDisplay(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFractionalDisplay(String)"})
  void testSetFractionalDisplay3() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFractionalDisplay(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE,
        pdNumberFormatDictionary.getFractionalDisplay());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFractionalDisplay(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFractionalDisplay(String)}
   */
  @Test
  @DisplayName(
      "Test setFractionalDisplay(String); then PDNumberFormatDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFractionalDisplay(String)"})
  void testSetFractionalDisplay_thenPDNumberFormatDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFractionalDisplay(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL,
        pdNumberFormatDictionary.getFractionalDisplay());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFractionalDisplay(String)}.
   *
   * <ul>
   *   <li>When {@code Fractional Display}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFractionalDisplay(String)}
   */
  @Test
  @DisplayName(
      "Test setFractionalDisplay(String); when 'Fractional Display'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFractionalDisplay(String)"})
  void testSetFractionalDisplay_whenFractionalDisplay_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDNumberFormatDictionary().setFractionalDisplay("Fractional Display"));
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFractionalDisplay(String)}.
   *
   * <ul>
   *   <li>When {@link PDNumberFormatDictionary#FRACTIONAL_DISPLAY_DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFractionalDisplay(String)}
   */
  @Test
  @DisplayName("Test setFractionalDisplay(String); when FRACTIONAL_DISPLAY_DECIMAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFractionalDisplay(String)"})
  void testSetFractionalDisplay_whenFractional_display_decimal() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFractionalDisplay(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL,
        pdNumberFormatDictionary.getFractionalDisplay());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getDenominator()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getDenominator()}
   */
  @Test
  @DisplayName("Test getDenominator(); given PDNumberFormatDictionary(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDNumberFormatDictionary.getDenominator()"})
  void testGetDenominator_givenPDNumberFormatDictionary_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDNumberFormatDictionary().getDenominator());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setDenominator(int)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} Denominator is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setDenominator(int)}
   */
  @Test
  @DisplayName("Test setDenominator(int); then PDNumberFormatDictionary() Denominator is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setDenominator(int)"})
  void testSetDenominator_thenPDNumberFormatDictionaryDenominatorIsMin_value() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setDenominator(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdNumberFormatDictionary.getDenominator());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setDenominator(int)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} Denominator is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setDenominator(int)}
   */
  @Test
  @DisplayName("Test setDenominator(int); then PDNumberFormatDictionary() Denominator is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setDenominator(int)"})
  void testSetDenominator_thenPDNumberFormatDictionaryDenominatorIsOne() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setDenominator(1);

    // Assert
    assertEquals(1, pdNumberFormatDictionary.getDenominator());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#isFD()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#isFD()}
   */
  @Test
  @DisplayName(
      "Test isFD(); given PDNumberFormatDictionary(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDNumberFormatDictionary.isFD()"})
  void testIsFD_givenPDNumberFormatDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDNumberFormatDictionary(new COSDictionary()).isFD());
  }

  /**
   * Test {@link PDNumberFormatDictionary#isFD()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#isFD()}
   */
  @Test
  @DisplayName("Test isFD(); given PDNumberFormatDictionary(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDNumberFormatDictionary.isFD()"})
  void testIsFD_givenPDNumberFormatDictionary_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDNumberFormatDictionary().isFD());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFD(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>When {@code true}.
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} FD.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFD(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFD(boolean); given PDNumberFormatDictionary(); when 'true'; then PDNumberFormatDictionary() FD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFD(boolean)"})
  void testSetFD_givenPDNumberFormatDictionary_whenTrue_thenPDNumberFormatDictionaryFd() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFD(true);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdNumberFormatDictionary.isFD());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setFD(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} FD.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setFD(boolean)}
   */
  @Test
  @DisplayName("Test setFD(boolean); when 'false'; then not PDNumberFormatDictionary() FD")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setFD(boolean)"})
  void testSetFD_whenFalse_thenNotPDNumberFormatDictionaryFd() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setFD(false);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdNumberFormatDictionary.isFD());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getThousandsSeparator()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getThousandsSeparator()}
   */
  @Test
  @DisplayName("Test getThousandsSeparator(); given PDNumberFormatDictionary(); then return ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getThousandsSeparator()"})
  void testGetThousandsSeparator_givenPDNumberFormatDictionary_thenReturnComma() {
    // Arrange, Act and Assert
    assertEquals(",", new PDNumberFormatDictionary().getThousandsSeparator());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setThousandsSeparator(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setThousandsSeparator(String)}
   */
  @Test
  @DisplayName("Test setThousandsSeparator(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setThousandsSeparator(String)"})
  void testSetThousandsSeparator() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setThousandsSeparator("Thousands Separator");

    // Assert
    assertEquals("Thousands Separator", pdNumberFormatDictionary.getThousandsSeparator());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setThousandsSeparator(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} ThousandsSeparator is
   *       {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setThousandsSeparator(String)}
   */
  @Test
  @DisplayName(
      "Test setThousandsSeparator(String); then PDNumberFormatDictionary() ThousandsSeparator is ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setThousandsSeparator(String)"})
  void testSetThousandsSeparator_thenPDNumberFormatDictionaryThousandsSeparatorIsComma() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setThousandsSeparator(null);

    // Assert that nothing has changed
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getDecimalSeparator()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getDecimalSeparator()}
   */
  @Test
  @DisplayName("Test getDecimalSeparator(); given PDNumberFormatDictionary(); then return '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getDecimalSeparator()"})
  void testGetDecimalSeparator_givenPDNumberFormatDictionary_thenReturnDot() {
    // Arrange, Act and Assert
    assertEquals(".", new PDNumberFormatDictionary().getDecimalSeparator());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setDecimalSeparator(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setDecimalSeparator(String)}
   */
  @Test
  @DisplayName("Test setDecimalSeparator(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setDecimalSeparator(String)"})
  void testSetDecimalSeparator() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setDecimalSeparator("Decimal Separator");

    // Assert
    assertEquals("Decimal Separator", pdNumberFormatDictionary.getDecimalSeparator());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setDecimalSeparator(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} DecimalSeparator is
   *       {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setDecimalSeparator(String)}
   */
  @Test
  @DisplayName(
      "Test setDecimalSeparator(String); then PDNumberFormatDictionary() DecimalSeparator is '.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setDecimalSeparator(String)"})
  void testSetDecimalSeparator_thenPDNumberFormatDictionaryDecimalSeparatorIsDot() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setDecimalSeparator(null);

    // Assert that nothing has changed
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getLabelPrefixString()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return space.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getLabelPrefixString()}
   */
  @Test
  @DisplayName("Test getLabelPrefixString(); given PDNumberFormatDictionary(); then return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getLabelPrefixString()"})
  void testGetLabelPrefixString_givenPDNumberFormatDictionary_thenReturnSpace() {
    // Arrange, Act and Assert
    assertEquals(" ", new PDNumberFormatDictionary().getLabelPrefixString());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelPrefixString(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelPrefixString(String)}
   */
  @Test
  @DisplayName("Test setLabelPrefixString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelPrefixString(String)"})
  void testSetLabelPrefixString() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelPrefixString("Label Prefix String");

    // Assert
    assertEquals("Label Prefix String", pdNumberFormatDictionary.getLabelPrefixString());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelPrefixString(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} LabelPrefixString is
   *       space.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelPrefixString(String)}
   */
  @Test
  @DisplayName(
      "Test setLabelPrefixString(String); then PDNumberFormatDictionary() LabelPrefixString is space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelPrefixString(String)"})
  void testSetLabelPrefixString_thenPDNumberFormatDictionaryLabelPrefixStringIsSpace() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelPrefixString(null);

    // Assert that nothing has changed
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getLabelSuffixString()}.
   *
   * <ul>
   *   <li>Given {@link PDNumberFormatDictionary#PDNumberFormatDictionary()}.
   *   <li>Then return space.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getLabelSuffixString()}
   */
  @Test
  @DisplayName("Test getLabelSuffixString(); given PDNumberFormatDictionary(); then return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getLabelSuffixString()"})
  void testGetLabelSuffixString_givenPDNumberFormatDictionary_thenReturnSpace() {
    // Arrange, Act and Assert
    assertEquals(" ", new PDNumberFormatDictionary().getLabelSuffixString());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelSuffixString(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelSuffixString(String)}
   */
  @Test
  @DisplayName("Test setLabelSuffixString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelSuffixString(String)"})
  void testSetLabelSuffixString() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelSuffixString("Label Suffix String");

    // Assert
    assertEquals("Label Suffix String", pdNumberFormatDictionary.getLabelSuffixString());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelSuffixString(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} LabelSuffixString is
   *       space.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelSuffixString(String)}
   */
  @Test
  @DisplayName(
      "Test setLabelSuffixString(String); then PDNumberFormatDictionary() LabelSuffixString is space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelSuffixString(String)"})
  void testSetLabelSuffixString_thenPDNumberFormatDictionaryLabelSuffixStringIsSpace() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelSuffixString(null);

    // Assert that nothing has changed
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNumberFormatDictionary#getLabelPositionToValue()}.
   *
   * <ul>
   *   <li>Then return {@link PDNumberFormatDictionary#LABEL_SUFFIX_TO_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#getLabelPositionToValue()}
   */
  @Test
  @DisplayName("Test getLabelPositionToValue(); then return LABEL_SUFFIX_TO_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNumberFormatDictionary.getLabelPositionToValue()"})
  void testGetLabelPositionToValue_thenReturnLabel_suffix_to_value() {
    // Arrange, Act and Assert
    assertEquals(
        PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE,
        new PDNumberFormatDictionary().getLabelPositionToValue());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}.
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}
   */
  @Test
  @DisplayName("Test setLabelPositionToValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelPositionToValue(String)"})
  void testSetLabelPositionToValue() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelPositionToValue(
        PDNumberFormatDictionary.LABEL_PREFIX_TO_VALUE);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.LABEL_PREFIX_TO_VALUE,
        pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}.
   *
   * <ul>
   *   <li>Then {@link PDNumberFormatDictionary#PDNumberFormatDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}
   */
  @Test
  @DisplayName(
      "Test setLabelPositionToValue(String); then PDNumberFormatDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelPositionToValue(String)"})
  void testSetLabelPositionToValue_thenPDNumberFormatDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelPositionToValue(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE,
        pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}
   */
  @Test
  @DisplayName(
      "Test setLabelPositionToValue(String); when '42'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelPositionToValue(String)"})
  void testSetLabelPositionToValue_when42_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDNumberFormatDictionary().setLabelPositionToValue("42"));
  }

  /**
   * Test {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}.
   *
   * <ul>
   *   <li>When {@link PDNumberFormatDictionary#LABEL_SUFFIX_TO_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDNumberFormatDictionary#setLabelPositionToValue(String)}
   */
  @Test
  @DisplayName("Test setLabelPositionToValue(String); when LABEL_SUFFIX_TO_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNumberFormatDictionary.setLabelPositionToValue(String)"})
  void testSetLabelPositionToValue_whenLabel_suffix_to_value() {
    // Arrange
    PDNumberFormatDictionary pdNumberFormatDictionary = new PDNumberFormatDictionary();

    // Act
    pdNumberFormatDictionary.setLabelPositionToValue(
        PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE);

    // Assert
    COSDictionary cOSObject = pdNumberFormatDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(
        PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE,
        pdNumberFormatDictionary.getLabelPositionToValue());
  }
}
