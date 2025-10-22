package org.apache.pdfbox.pdmodel.interactive.measurement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMeasureDictionaryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDMeasureDictionary#PDMeasureDictionary(COSDictionary)}
   *   <li>{@link PDMeasureDictionary#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMeasureDictionary.<init>(COSDictionary)", "String PDMeasureDictionary.getType()"})
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDMeasureDictionary actualPdMeasureDictionary = new PDMeasureDictionary(dictionary);

    // Assert
    assertEquals(PDMeasureDictionary.TYPE, actualPdMeasureDictionary.getType());
    assertSame(dictionary, actualPdMeasureDictionary.getCOSObject());
  }

  /**
   * Test {@link PDMeasureDictionary#PDMeasureDictionary()}.
   * <p>
   * Method under test: {@link PDMeasureDictionary#PDMeasureDictionary()}
   */
  @Test
  @DisplayName("Test new PDMeasureDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMeasureDictionary.<init>()"})
  void testNewPDMeasureDictionary() {
    // Arrange and Act
    PDMeasureDictionary actualPdMeasureDictionary = new PDMeasureDictionary();

    // Assert
    COSDictionary cOSObject = actualPdMeasureDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDMeasureDictionary.TYPE, actualPdMeasureDictionary.getType());
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, actualPdMeasureDictionary.getSubtype());
  }

  /**
   * Test {@link PDMeasureDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link PDMeasureDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDMeasureDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDMeasureDictionary()).getCOSObject();

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
   * Test {@link PDMeasureDictionary#getSubtype()}.
   * <ul>
   *   <li>Given {@link PDMeasureDictionary#PDMeasureDictionary()}.</li>
   *   <li>Then return {@link PDRectlinearMeasureDictionary#SUBTYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMeasureDictionary#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDMeasureDictionary(); then return SUBTYPE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDMeasureDictionary.getSubtype()"})
  void testGetSubtype_givenPDMeasureDictionary_thenReturnSubtype() {
    // Arrange, Act and Assert
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, (new PDMeasureDictionary()).getSubtype());
  }

  /**
   * Test {@link PDMeasureDictionary#getSubtype()}.
   * <ul>
   *   <li>Given {@link PDRectlinearMeasureDictionary#PDRectlinearMeasureDictionary()}.</li>
   *   <li>Then return {@link PDRectlinearMeasureDictionary#SUBTYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMeasureDictionary#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDRectlinearMeasureDictionary(); then return SUBTYPE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDMeasureDictionary.getSubtype()"})
  void testGetSubtype_givenPDRectlinearMeasureDictionary_thenReturnSubtype() {
    // Arrange, Act and Assert
    assertEquals(PDRectlinearMeasureDictionary.SUBTYPE, (new PDRectlinearMeasureDictionary()).getSubtype());
  }

  /**
   * Test {@link PDMeasureDictionary#setSubtype(String)}.
   * <ul>
   *   <li>Given {@link PDMeasureDictionary#PDMeasureDictionary()}.</li>
   *   <li>Then {@link PDMeasureDictionary#PDMeasureDictionary()} Subtype is {@code Subtype}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMeasureDictionary#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); given PDMeasureDictionary(); then PDMeasureDictionary() Subtype is 'Subtype'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMeasureDictionary.setSubtype(String)"})
  void testSetSubtype_givenPDMeasureDictionary_thenPDMeasureDictionarySubtypeIsSubtype() {
    // Arrange
    PDMeasureDictionary pdMeasureDictionary = new PDMeasureDictionary();

    // Act
    pdMeasureDictionary.setSubtype("Subtype");

    // Assert
    assertEquals("Subtype", pdMeasureDictionary.getSubtype());
    COSDictionary cOSObject = pdMeasureDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDMeasureDictionary#setSubtype(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDMeasureDictionary#PDMeasureDictionary()} Subtype is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDMeasureDictionary#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); when '42'; then PDMeasureDictionary() Subtype is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDMeasureDictionary.setSubtype(String)"})
  void testSetSubtype_when42_thenPDMeasureDictionarySubtypeIs42() {
    // Arrange
    PDMeasureDictionary pdMeasureDictionary = new PDMeasureDictionary();

    // Act
    pdMeasureDictionary.setSubtype("42");

    // Assert
    assertEquals("42", pdMeasureDictionary.getSubtype());
    COSDictionary cOSObject = pdMeasureDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
