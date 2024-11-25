package org.apache.pdfbox.pdmodel.interactive.measurement;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDRectlinearMeasureDictionaryDiffblueTest {
  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDRectlinearMeasureDictionary(COSDictionary)")
  void testNewPDRectlinearMeasureDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDRectlinearMeasureDictionary(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}
   */
  @Test
  @DisplayName("Test new PDRectlinearMeasureDictionary()")
  void testNewPDRectlinearMeasureDictionary2() {
    // Arrange and Act
    PDRectlinearMeasureDictionary actualPdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Assert
    assertNull(actualPdRectlinearMeasureDictionary.getCoordSystemOrigin());
    assertNull(actualPdRectlinearMeasureDictionary.getAngles());
    assertNull(actualPdRectlinearMeasureDictionary.getAreas());
    assertNull(actualPdRectlinearMeasureDictionary.getChangeXs());
    assertNull(actualPdRectlinearMeasureDictionary.getChangeYs());
    assertNull(actualPdRectlinearMeasureDictionary.getDistances());
    assertNull(actualPdRectlinearMeasureDictionary.getLineSloaps());
    assertNull(actualPdRectlinearMeasureDictionary.getScaleRatio());
    COSDictionary cOSObject = actualPdRectlinearMeasureDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1.0f, actualPdRectlinearMeasureDictionary.getCYX());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDMeasureDictionary.TYPE, actualPdRectlinearMeasureDictionary.getType());
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, actualPdRectlinearMeasureDictionary.getSubtype());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getScaleRatio()}.
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getScaleRatio()}
   */
  @Test
  @DisplayName("Test getScaleRatio()")
  void testGetScaleRatio() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getScaleRatio());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getScaleRatio()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getScaleRatio()}
   */
  @Test
  @DisplayName("Test getScaleRatio(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetScaleRatio_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getScaleRatio());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#setScaleRatio(String)}.
   * <ul>
   *   <li>Then
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}
   * ScaleRatio is {@code Scale Ratio}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setScaleRatio(String)}
   */
  @Test
  @DisplayName("Test setScaleRatio(String); then PDRectlinearMeasureDictionary() ScaleRatio is 'Scale Ratio'")
  void testSetScaleRatio_thenPDRectlinearMeasureDictionaryScaleRatioIsScaleRatio() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setScaleRatio("Scale Ratio");

    // Assert
    assertEquals("Scale Ratio", pdRectlinearMeasureDictionary.getScaleRatio());
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getChangeXs()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   * with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getChangeXs()}
   */
  @Test
  @DisplayName("Test getChangeXs(); given PDRectlinearMeasureDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetChangeXs_givenPDRectlinearMeasureDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getChangeXs());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getChangeXs()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getChangeXs()}
   */
  @Test
  @DisplayName("Test getChangeXs(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetChangeXs_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getChangeXs());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeXs(PDNumberFormatDictionary[]); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetChangeXs_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdRectlinearMeasureDictionary.setChangeXs(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then first element COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeXs(PDNumberFormatDictionary[]); given 'true'; then first element COSObject is COSDictionary()")
  void testSetChangeXs_givenTrue_thenFirstElementCOSObjectIsCOSDictionary() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdRectlinearMeasureDictionary.setChangeXs(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    PDNumberFormatDictionary[] changeXs = pdRectlinearMeasureDictionary.getChangeXs();
    PDNumberFormatDictionary pdNumberFormatDictionary = changeXs[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, changeXs.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
    assertSame(dictionary, pdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeXs(PDNumberFormatDictionary[]); then first element COSObject is 'null'")
  void testSetChangeXs_thenFirstElementCOSObjectIsNull() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setChangeXs(new PDNumberFormatDictionary[]{null});

    // Assert
    PDNumberFormatDictionary[] changeXs = pdRectlinearMeasureDictionary.getChangeXs();
    PDNumberFormatDictionary pdNumberFormatDictionary = changeXs[0];
    assertNull(pdNumberFormatDictionary.getCOSObject());
    assertEquals(1, changeXs.length);
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDNumberFormatDictionary.TYPE, pdNumberFormatDictionary.getType());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element LabelPrefixString is space.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeXs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeXs(PDNumberFormatDictionary[]); then first element LabelPrefixString is space")
  void testSetChangeXs_thenFirstElementLabelPrefixStringIsSpace() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setChangeXs(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary()});

    // Assert
    PDNumberFormatDictionary[] changeXs = pdRectlinearMeasureDictionary.getChangeXs();
    PDNumberFormatDictionary pdNumberFormatDictionary = changeXs[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, changeXs.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getChangeYs()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   * with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getChangeYs()}
   */
  @Test
  @DisplayName("Test getChangeYs(); given PDRectlinearMeasureDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetChangeYs_givenPDRectlinearMeasureDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getChangeYs());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getChangeYs()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getChangeYs()}
   */
  @Test
  @DisplayName("Test getChangeYs(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetChangeYs_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getChangeYs());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeYs(PDNumberFormatDictionary[]); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetChangeYs_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdRectlinearMeasureDictionary.setChangeYs(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then first element COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeYs(PDNumberFormatDictionary[]); given 'true'; then first element COSObject is COSDictionary()")
  void testSetChangeYs_givenTrue_thenFirstElementCOSObjectIsCOSDictionary() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdRectlinearMeasureDictionary.setChangeYs(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    PDNumberFormatDictionary[] changeYs = pdRectlinearMeasureDictionary.getChangeYs();
    PDNumberFormatDictionary pdNumberFormatDictionary = changeYs[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, changeYs.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
    assertSame(dictionary, pdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeYs(PDNumberFormatDictionary[]); then first element COSObject is 'null'")
  void testSetChangeYs_thenFirstElementCOSObjectIsNull() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setChangeYs(new PDNumberFormatDictionary[]{null});

    // Assert
    PDNumberFormatDictionary[] changeYs = pdRectlinearMeasureDictionary.getChangeYs();
    PDNumberFormatDictionary pdNumberFormatDictionary = changeYs[0];
    assertNull(pdNumberFormatDictionary.getCOSObject());
    assertEquals(1, changeYs.length);
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDNumberFormatDictionary.TYPE, pdNumberFormatDictionary.getType());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element LabelPrefixString is space.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setChangeYs(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setChangeYs(PDNumberFormatDictionary[]); then first element LabelPrefixString is space")
  void testSetChangeYs_thenFirstElementLabelPrefixStringIsSpace() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setChangeYs(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary()});

    // Assert
    PDNumberFormatDictionary[] changeYs = pdRectlinearMeasureDictionary.getChangeYs();
    PDNumberFormatDictionary pdNumberFormatDictionary = changeYs[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, changeYs.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getDistances()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   * with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getDistances()}
   */
  @Test
  @DisplayName("Test getDistances(); given PDRectlinearMeasureDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetDistances_givenPDRectlinearMeasureDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getDistances());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getDistances()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getDistances()}
   */
  @Test
  @DisplayName("Test getDistances(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetDistances_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getDistances());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setDistances(PDNumberFormatDictionary[]); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetDistances_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdRectlinearMeasureDictionary
        .setDistances(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then first element COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setDistances(PDNumberFormatDictionary[]); given 'true'; then first element COSObject is COSDictionary()")
  void testSetDistances_givenTrue_thenFirstElementCOSObjectIsCOSDictionary() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdRectlinearMeasureDictionary
        .setDistances(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    PDNumberFormatDictionary[] distances = pdRectlinearMeasureDictionary.getDistances();
    PDNumberFormatDictionary pdNumberFormatDictionary = distances[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, distances.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
    assertSame(dictionary, pdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setDistances(PDNumberFormatDictionary[]); then first element COSObject is 'null'")
  void testSetDistances_thenFirstElementCOSObjectIsNull() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setDistances(new PDNumberFormatDictionary[]{null});

    // Assert
    PDNumberFormatDictionary[] distances = pdRectlinearMeasureDictionary.getDistances();
    PDNumberFormatDictionary pdNumberFormatDictionary = distances[0];
    assertNull(pdNumberFormatDictionary.getCOSObject());
    assertEquals(1, distances.length);
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDNumberFormatDictionary.TYPE, pdNumberFormatDictionary.getType());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element LabelPrefixString is space.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setDistances(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setDistances(PDNumberFormatDictionary[]); then first element LabelPrefixString is space")
  void testSetDistances_thenFirstElementLabelPrefixStringIsSpace() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setDistances(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary()});

    // Assert
    PDNumberFormatDictionary[] distances = pdRectlinearMeasureDictionary.getDistances();
    PDNumberFormatDictionary pdNumberFormatDictionary = distances[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, distances.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getAreas()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   * with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getAreas()}
   */
  @Test
  @DisplayName("Test getAreas(); given PDRectlinearMeasureDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetAreas_givenPDRectlinearMeasureDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getAreas());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getAreas()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getAreas()}
   */
  @Test
  @DisplayName("Test getAreas(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetAreas_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getAreas());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAreas(PDNumberFormatDictionary[]); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetAreas_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdRectlinearMeasureDictionary.setAreas(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then first element COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAreas(PDNumberFormatDictionary[]); given 'true'; then first element COSObject is COSDictionary()")
  void testSetAreas_givenTrue_thenFirstElementCOSObjectIsCOSDictionary() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdRectlinearMeasureDictionary.setAreas(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    PDNumberFormatDictionary[] areas = pdRectlinearMeasureDictionary.getAreas();
    PDNumberFormatDictionary pdNumberFormatDictionary = areas[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, areas.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
    assertSame(dictionary, pdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAreas(PDNumberFormatDictionary[]); then first element COSObject is 'null'")
  void testSetAreas_thenFirstElementCOSObjectIsNull() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setAreas(new PDNumberFormatDictionary[]{null});

    // Assert
    PDNumberFormatDictionary[] areas = pdRectlinearMeasureDictionary.getAreas();
    PDNumberFormatDictionary pdNumberFormatDictionary = areas[0];
    assertNull(pdNumberFormatDictionary.getCOSObject());
    assertEquals(1, areas.length);
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDNumberFormatDictionary.TYPE, pdNumberFormatDictionary.getType());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element LabelPrefixString is space.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAreas(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAreas(PDNumberFormatDictionary[]); then first element LabelPrefixString is space")
  void testSetAreas_thenFirstElementLabelPrefixStringIsSpace() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setAreas(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary()});

    // Assert
    PDNumberFormatDictionary[] areas = pdRectlinearMeasureDictionary.getAreas();
    PDNumberFormatDictionary pdNumberFormatDictionary = areas[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, areas.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getAngles()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   * with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getAngles()}
   */
  @Test
  @DisplayName("Test getAngles(); given PDRectlinearMeasureDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetAngles_givenPDRectlinearMeasureDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getAngles());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getAngles()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getAngles()}
   */
  @Test
  @DisplayName("Test getAngles(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetAngles_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getAngles());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAngles(PDNumberFormatDictionary[]); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetAngles_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdRectlinearMeasureDictionary.setAngles(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then first element COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAngles(PDNumberFormatDictionary[]); given 'true'; then first element COSObject is COSDictionary()")
  void testSetAngles_givenTrue_thenFirstElementCOSObjectIsCOSDictionary() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdRectlinearMeasureDictionary.setAngles(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    PDNumberFormatDictionary[] angles = pdRectlinearMeasureDictionary.getAngles();
    PDNumberFormatDictionary pdNumberFormatDictionary = angles[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, angles.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
    assertSame(dictionary, pdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAngles(PDNumberFormatDictionary[]); then first element COSObject is 'null'")
  void testSetAngles_thenFirstElementCOSObjectIsNull() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setAngles(new PDNumberFormatDictionary[]{null});

    // Assert
    PDNumberFormatDictionary[] angles = pdRectlinearMeasureDictionary.getAngles();
    PDNumberFormatDictionary pdNumberFormatDictionary = angles[0];
    assertNull(pdNumberFormatDictionary.getCOSObject());
    assertEquals(1, angles.length);
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDNumberFormatDictionary.TYPE, pdNumberFormatDictionary.getType());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element LabelPrefixString is space.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setAngles(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setAngles(PDNumberFormatDictionary[]); then first element LabelPrefixString is space")
  void testSetAngles_thenFirstElementLabelPrefixStringIsSpace() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setAngles(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary()});

    // Assert
    PDNumberFormatDictionary[] angles = pdRectlinearMeasureDictionary.getAngles();
    PDNumberFormatDictionary pdNumberFormatDictionary = angles[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, angles.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getLineSloaps()}.
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getLineSloaps()}
   */
  @Test
  @DisplayName("Test getLineSloaps()")
  void testGetLineSloaps() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getLineSloaps());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getLineSloaps()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getLineSloaps()}
   */
  @Test
  @DisplayName("Test getLineSloaps(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetLineSloaps_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getLineSloaps());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setLineSloaps(PDNumberFormatDictionary[]); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetLineSloaps_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdRectlinearMeasureDictionary
        .setLineSloaps(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then first element COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setLineSloaps(PDNumberFormatDictionary[]); given 'true'; then first element COSObject is COSDictionary()")
  void testSetLineSloaps_givenTrue_thenFirstElementCOSObjectIsCOSDictionary() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdRectlinearMeasureDictionary
        .setLineSloaps(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary(dictionary)});

    // Assert
    PDNumberFormatDictionary[] lineSloaps = pdRectlinearMeasureDictionary.getLineSloaps();
    PDNumberFormatDictionary pdNumberFormatDictionary = lineSloaps[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, lineSloaps.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
    assertSame(dictionary, pdNumberFormatDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setLineSloaps(PDNumberFormatDictionary[]); then first element COSObject is 'null'")
  void testSetLineSloaps_thenFirstElementCOSObjectIsNull() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setLineSloaps(new PDNumberFormatDictionary[]{null});

    // Assert
    PDNumberFormatDictionary[] lineSloaps = pdRectlinearMeasureDictionary.getLineSloaps();
    PDNumberFormatDictionary pdNumberFormatDictionary = lineSloaps[0];
    assertNull(pdNumberFormatDictionary.getCOSObject());
    assertEquals(1, lineSloaps.length);
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDNumberFormatDictionary.TYPE, pdNumberFormatDictionary.getType());
  }

  /**
   * Test
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}.
   * <ul>
   *   <li>Then first element LabelPrefixString is space.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setLineSloaps(PDNumberFormatDictionary[])}
   */
  @Test
  @DisplayName("Test setLineSloaps(PDNumberFormatDictionary[]); then first element LabelPrefixString is space")
  void testSetLineSloaps_thenFirstElementLabelPrefixStringIsSpace() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setLineSloaps(new PDNumberFormatDictionary[]{new PDNumberFormatDictionary()});

    // Assert
    PDNumberFormatDictionary[] lineSloaps = pdRectlinearMeasureDictionary.getLineSloaps();
    PDNumberFormatDictionary pdNumberFormatDictionary = lineSloaps[0];
    assertEquals(" ", pdNumberFormatDictionary.getLabelPrefixString());
    assertEquals(" ", pdNumberFormatDictionary.getLabelSuffixString());
    assertEquals(",", pdNumberFormatDictionary.getThousandsSeparator());
    assertEquals(".", pdNumberFormatDictionary.getDecimalSeparator());
    assertNull(pdNumberFormatDictionary.getUnits());
    assertEquals(-1, pdNumberFormatDictionary.getDenominator());
    assertEquals(-1.0f, pdNumberFormatDictionary.getConversionFactor());
    assertEquals(1, lineSloaps.length);
    assertFalse(pdNumberFormatDictionary.isFD());
    assertEquals(PDNumberFormatDictionary.FRACTIONAL_DISPLAY_DECIMAL, pdNumberFormatDictionary.getFractionalDisplay());
    assertEquals(PDNumberFormatDictionary.LABEL_SUFFIX_TO_VALUE, pdNumberFormatDictionary.getLabelPositionToValue());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getCoordSystemOrigin()}.
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#getCoordSystemOrigin()}
   */
  @Test
  @DisplayName("Test getCoordSystemOrigin()")
  void testGetCoordSystemOrigin() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary(new COSDictionary())).getCoordSystemOrigin());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getCoordSystemOrigin()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#getCoordSystemOrigin()}
   */
  @Test
  @DisplayName("Test getCoordSystemOrigin(); given PDRectlinearMeasureDictionary(); then return 'null'")
  void testGetCoordSystemOrigin_givenPDRectlinearMeasureDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDRectlinearMeasureDictionary()).getCoordSystemOrigin());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#setCoordSystemOrigin(float[])}.
   * <p>
   * Method under test:
   * {@link PDRectlinearMeasureDictionary#setCoordSystemOrigin(float[])}
   */
  @Test
  @DisplayName("Test setCoordSystemOrigin(float[])")
  void testSetCoordSystemOrigin() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setCoordSystemOrigin(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdRectlinearMeasureDictionary.getCoordSystemOrigin(),
        0.0f);
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getCYX()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary(COSDictionary)}
   * with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getCYX()}
   */
  @Test
  @DisplayName("Test getCYX(); given PDRectlinearMeasureDictionary(COSDictionary) with dictionary is COSDictionary()")
  void testGetCYX_givenPDRectlinearMeasureDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDRectlinearMeasureDictionary(new COSDictionary())).getCYX());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#getCYX()}.
   * <ul>
   *   <li>Given
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#getCYX()}
   */
  @Test
  @DisplayName("Test getCYX(); given PDRectlinearMeasureDictionary(); then return minus one")
  void testGetCYX_givenPDRectlinearMeasureDictionary_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDRectlinearMeasureDictionary()).getCYX());
  }

  /**
   * Test {@link PDRectlinearMeasureDictionary#setCYX(float)}.
   * <ul>
   *   <li>Then
   * {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()} CYX is
   * ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRectlinearMeasureDictionary#setCYX(float)}
   */
  @Test
  @DisplayName("Test setCYX(float); then PDRectlinearMeasureDictionary() CYX is ten")
  void testSetCYX_thenPDRectlinearMeasureDictionaryCyxIsTen() {
    // Arrange
    PDRectlinearMeasureDictionary pdRectlinearMeasureDictionary = new PDRectlinearMeasureDictionary();

    // Act
    pdRectlinearMeasureDictionary.setCYX(10.0f);

    // Assert
    assertEquals(10.0f, pdRectlinearMeasureDictionary.getCYX());
    COSDictionary cOSObject = pdRectlinearMeasureDictionary.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
