package org.apache.pdfbox.pdmodel.interactive.measurement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDViewportDictionaryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDViewportDictionary#PDViewportDictionary(COSDictionary)}
   *   <li>{@link PDViewportDictionary#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDViewportDictionary.<init>(COSDictionary)",
    "String PDViewportDictionary.getType()"
  })
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
   *
   * <p>Method under test: {@link PDViewportDictionary#PDViewportDictionary()}
   */
  @Test
  @DisplayName("Test new PDViewportDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.<init>()"})
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
   *
   * <p>Method under test: {@link PDViewportDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDViewportDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDViewportDictionary().getCOSObject();

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
   *
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDViewportDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDViewportDictionary.getBBox()"})
  void testGetBBox_givenPDViewportDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDViewportDictionary().getBBox());
  }

  /**
   * Test {@link PDViewportDictionary#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} BBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); then PDViewportDictionary() BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setBBox(PDRectangle)"})
  void testSetBBox_thenPDViewportDictionaryBBoxLowerLeftXIsZero() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setBBox(PDRectangle.A0);

    // Assert
    PDRectangle bBox = pdViewportDictionary.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }

  /**
   * Test {@link PDViewportDictionary#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBBox(PDRectangle); when 'null'; then PDViewportDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setBBox(PDRectangle)"})
  void testSetBBox_whenNull_thenPDViewportDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setBBox(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDViewportDictionary#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDViewportDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDViewportDictionary.getName()"})
  void testGetName_givenPDViewportDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDViewportDictionary().getName());
  }

  /**
   * Test {@link PDViewportDictionary#setName(String)}.
   *
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); given PDViewportDictionary(); when '42'; then PDViewportDictionary() Name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setName(String)"})
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
   * Test {@link PDViewportDictionary#setName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String); when 'Name'; then PDViewportDictionary() Name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setName(String)"})
  void testSetName_whenName_thenPDViewportDictionaryNameIsName() {
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setName(String)}
   */
  @Test
  @DisplayName(
      "Test setName(String); when 'null'; then PDViewportDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setName(String)"})
  void testSetName_whenNull_thenPDViewportDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setName(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDViewportDictionary#getMeasure()}.
   *
   * <ul>
   *   <li>Given {@link PDViewportDictionary#PDViewportDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#getMeasure()}
   */
  @Test
  @DisplayName("Test getMeasure(); given PDViewportDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDMeasureDictionary PDViewportDictionary.getMeasure()"})
  void testGetMeasure_givenPDViewportDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDViewportDictionary().getMeasure());
  }

  /**
   * Test {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}.
   *
   * <p>Method under test: {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName("Test setMeasure(PDMeasureDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setMeasure(PDMeasureDictionary)"})
  void testSetMeasure() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary(new COSDictionary());

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
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName(
      "Test setMeasure(PDMeasureDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setMeasure(PDMeasureDictionary)"})
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
   *
   * <ul>
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} Measure COSObject is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName(
      "Test setMeasure(PDMeasureDictionary); then PDViewportDictionary() Measure COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setMeasure(PDMeasureDictionary)"})
  void testSetMeasure_thenPDViewportDictionaryMeasureCOSObjectIsCOSDictionary() {
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDViewportDictionary#PDViewportDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName(
      "Test setMeasure(PDMeasureDictionary); when 'null'; then PDViewportDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setMeasure(PDMeasureDictionary)"})
  void testSetMeasure_whenNull_thenPDViewportDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDViewportDictionary pdViewportDictionary = new PDViewportDictionary();

    // Act
    pdViewportDictionary.setMeasure(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdViewportDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDMeasureDictionary#PDMeasureDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDViewportDictionary#setMeasure(PDMeasureDictionary)}
   */
  @Test
  @DisplayName("Test setMeasure(PDMeasureDictionary); when PDMeasureDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDViewportDictionary.setMeasure(PDMeasureDictionary)"})
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
