package org.apache.pdfbox.pdmodel.interactive.measurement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDViewportDictionaryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDViewportDictionary#PDViewportDictionary(COSDictionary)}
   *   <li>{@link PDViewportDictionary#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDViewportDictionary actualPdViewportDictionary = new PDViewportDictionary(dictionary);

    // Assert
    assertEquals(PDViewportDictionary.TYPE, actualPdViewportDictionary.getType());
    assertSame(dictionary, actualPdViewportDictionary.getCOSObject());
  }

  /**
   * Test {@link PDViewportDictionary#PDViewportDictionary()}.
   * <p>
   * Method under test: {@link PDViewportDictionary#PDViewportDictionary()}
   */
  @Test
  @DisplayName("Test new PDViewportDictionary()")
  void testNewPDViewportDictionary() {
    // Arrange and Act
    PDViewportDictionary actualPdViewportDictionary = new PDViewportDictionary();

    // Assert
    assertNull(actualPdViewportDictionary.getName());
    COSDictionary cOSObject = actualPdViewportDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdViewportDictionary.getBBox());
    assertNull(actualPdViewportDictionary.getMeasure());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDViewportDictionary.TYPE, actualPdViewportDictionary.getType());
  }

  /**
   * Test {@link PDViewportDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link PDViewportDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDViewportDictionary()).getCOSObject();

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
   * Test {@link PDViewportDictionary#getBBox()}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary(COSDictionary)}
   * with dictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDViewportDictionary(COSDictionary) with dictionary is COSStream(); then return 'null'")
  void testGetBBox_givenPDViewportDictionaryWithDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDViewportDictionary(new COSStream())).getBBox());
  }

  /**
   * Test {@link PDViewportDictionary#getBBox()}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDViewportDictionary(); then return 'null'")
  void testGetBBox_givenPDViewportDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDViewportDictionary()).getBBox());
  }

  /**
   * Test {@link PDViewportDictionary#setBBox(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} COSObject
   * toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); when 'null'; then PDViewportDictionary() COSObject toIncrement Objects Empty")
  void testSetBBox_whenNull_thenPDViewportDictionaryCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setBBox(null);

    // Assert
    COSIncrement toIncrementResult = pdViewportDictionary.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDViewportDictionary#setBBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} BBox Height is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); when PDRectangle(); then PDViewportDictionary() BBox Height is zero")
  void testSetBBox_whenPDRectangle_thenPDViewportDictionaryBBoxHeightIsZero() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setBBox(new PDRectangle());

    // Assert
    PDRectangle bBox = pdViewportDictionary.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(0.0f, bBox.getUpperRightY());
    assertEquals(0.0f, bBox.getWidth());
  }

  /**
   * Test {@link PDViewportDictionary#getName()}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary(COSDictionary)}
   * with dictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDViewportDictionary(COSDictionary) with dictionary is COSStream(); then return 'null'")
  void testGetName_givenPDViewportDictionaryWithDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDViewportDictionary(new COSStream())).getName());
  }

  /**
   * Test {@link PDViewportDictionary#getName()}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDViewportDictionary(); then return 'null'")
  void testGetName_givenPDViewportDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDViewportDictionary()).getName());
  }

  /**
   * Test {@link PDViewportDictionary#setName(String)}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} Name is
   * {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); given PDViewportDictionary(); then PDViewportDictionary() Name is 'Name'")
  void testSetName_givenPDViewportDictionary_thenPDViewportDictionaryNameIsName() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setName("Name");

    // Assert
    assertEquals("Name", pdViewportDictionary.getName());
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewportDictionary#setName(String)}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} Name is
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); given PDViewportDictionary(); when '42'; then PDViewportDictionary() Name is '42'")
  void testSetName_givenPDViewportDictionary_when42_thenPDViewportDictionaryNameIs42() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setName("42");

    // Assert
    assertEquals("42", pdViewportDictionary.getName());
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDViewportDictionary#getMeasure()}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary(COSDictionary)}
   * with dictionary is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#getMeasure()}
   */
  @Test
  @DisplayName("Test getMeasure(); given PDViewportDictionary(COSDictionary) with dictionary is COSStream(); then return 'null'")
  void testGetMeasure_givenPDViewportDictionaryWithDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDViewportDictionary(new COSStream())).getMeasure());
  }

  /**
   * Test {@link PDViewportDictionary#getMeasure()}.
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDViewportDictionary#getMeasure()}
   */
  @Test
  @DisplayName("Test getMeasure(); given PDViewportDictionary(); then return 'null'")
  void testGetMeasure_givenPDViewportDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDViewportDictionary()).getMeasure());
  }

  /**
   * Test {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName("Test setMeasure(PDMeasureDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetMeasure_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    pdViewportDictionary.setMeasure(new PDMeasureDictionary(dictionary));

    // Assert
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDMeasureDictionary measure = pdViewportDictionary.getMeasure();
    assertEquals(PDMeasureDictionary.TYPE, measure.getType());
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, measure.getSubtype());
    assertSame(dictionary, measure.getCOSObject());
  }

  /**
   * Test {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName("Test setMeasure(PDMeasureDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetMeasure_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    COSDictionary dictionary = new COSDictionary();
    dictionary.setDirect(true);

    // Act
    pdViewportDictionary.setMeasure(new PDMeasureDictionary(dictionary));

    // Assert
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDMeasureDictionary measure = pdViewportDictionary.getMeasure();
    assertEquals(PDMeasureDictionary.TYPE, measure.getType());
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, measure.getSubtype());
    assertSame(dictionary, measure.getCOSObject());
  }

  /**
   * Test {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} COSObject size
   * is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName("Test setMeasure(PDMeasureDictionary); when 'null'; then PDViewportDictionary() COSObject size is zero")
  void testSetMeasure_whenNull_thenPDViewportDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setMeasure(null);

    // Assert
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}.
   * <ul>
   *   <li>When {@link PDMeasureDictionary#PDMeasureDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName("Test setMeasure(PDMeasureDictionary); when PDMeasureDictionary()")
  void testSetMeasure_whenPDMeasureDictionary() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setMeasure(new PDMeasureDictionary());

    // Assert
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDMeasureDictionary measure = pdViewportDictionary.getMeasure();
    assertEquals(PDMeasureDictionary.TYPE, measure.getType());
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, measure.getSubtype());
  }
}
