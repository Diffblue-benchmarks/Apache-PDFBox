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

class PDExternalDataDictionaryDiffblueTest {
  /**
   * Test {@link PDExternalDataDictionary#PDExternalDataDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link PDExternalDataDictionary#PDExternalDataDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDExternalDataDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExternalDataDictionary.<init>(COSDictionary)"})
  void testNewPDExternalDataDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDExternalDataDictionary(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDExternalDataDictionary#PDExternalDataDictionary()}.
   *
   * <p>Method under test: {@link PDExternalDataDictionary#PDExternalDataDictionary()}
   */
  @Test
  @DisplayName("Test new PDExternalDataDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExternalDataDictionary.<init>()"})
  void testNewPDExternalDataDictionary2() {
    // Arrange and Act
    PDExternalDataDictionary actualPdExternalDataDictionary = new PDExternalDataDictionary();

    // Assert
    assertEquals("ExData", actualPdExternalDataDictionary.getType());
    assertNull(actualPdExternalDataDictionary.getSubtype());
    COSDictionary cOSObject = actualPdExternalDataDictionary.getCOSObject();
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
  }

  /**
   * Test {@link PDExternalDataDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDExternalDataDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDExternalDataDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDExternalDataDictionary().getCOSObject();

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
   * Test {@link PDExternalDataDictionary#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDExternalDataDictionary#PDExternalDataDictionary(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#getType()}
   */
  @Test
  @DisplayName(
      "Test getType(); given PDExternalDataDictionary(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDExternalDataDictionary.getType()"})
  void testGetType_givenPDExternalDataDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("ExData", new PDExternalDataDictionary(new COSDictionary()).getType());
  }

  /**
   * Test {@link PDExternalDataDictionary#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDExternalDataDictionary#PDExternalDataDictionary()}.
   *   <li>Then return {@code ExData}.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDExternalDataDictionary(); then return 'ExData'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDExternalDataDictionary.getType()"})
  void testGetType_givenPDExternalDataDictionary_thenReturnExData() {
    // Arrange, Act and Assert
    assertEquals("ExData", new PDExternalDataDictionary().getType());
  }

  /**
   * Test {@link PDExternalDataDictionary#getSubtype()}.
   *
   * <ul>
   *   <li>Given {@link PDExternalDataDictionary#PDExternalDataDictionary(COSDictionary)} with
   *       dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#getSubtype()}
   */
  @Test
  @DisplayName(
      "Test getSubtype(); given PDExternalDataDictionary(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDExternalDataDictionary.getSubtype()"})
  void testGetSubtype_givenPDExternalDataDictionaryWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDExternalDataDictionary(new COSDictionary()).getSubtype());
  }

  /**
   * Test {@link PDExternalDataDictionary#getSubtype()}.
   *
   * <ul>
   *   <li>Given {@link PDExternalDataDictionary#PDExternalDataDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDExternalDataDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDExternalDataDictionary.getSubtype()"})
  void testGetSubtype_givenPDExternalDataDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDExternalDataDictionary().getSubtype());
  }

  /**
   * Test {@link PDExternalDataDictionary#setSubtype(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDExternalDataDictionary#PDExternalDataDictionary()} Subtype is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#setSubtype(String)}
   */
  @Test
  @DisplayName(
      "Test setSubtype(String); when '42'; then PDExternalDataDictionary() Subtype is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExternalDataDictionary.setSubtype(String)"})
  void testSetSubtype_when42_thenPDExternalDataDictionarySubtypeIs42() {
    // Arrange
    PDExternalDataDictionary pdExternalDataDictionary = new PDExternalDataDictionary();

    // Act
    pdExternalDataDictionary.setSubtype("42");

    // Assert
    assertEquals("42", pdExternalDataDictionary.getSubtype());
    COSDictionary cOSObject = pdExternalDataDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDExternalDataDictionary#setSubtype(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDExternalDataDictionary#PDExternalDataDictionary()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#setSubtype(String)}
   */
  @Test
  @DisplayName(
      "Test setSubtype(String); when 'null'; then PDExternalDataDictionary() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExternalDataDictionary.setSubtype(String)"})
  void testSetSubtype_whenNull_thenPDExternalDataDictionaryCOSObjectValuesSizeIsOne() {
    // Arrange
    PDExternalDataDictionary pdExternalDataDictionary = new PDExternalDataDictionary();

    // Act
    pdExternalDataDictionary.setSubtype(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdExternalDataDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDExternalDataDictionary#setSubtype(String)}.
   *
   * <ul>
   *   <li>When {@code Subtype}.
   *   <li>Then {@link PDExternalDataDictionary#PDExternalDataDictionary()} Subtype is {@code
   *       Subtype}.
   * </ul>
   *
   * <p>Method under test: {@link PDExternalDataDictionary#setSubtype(String)}
   */
  @Test
  @DisplayName(
      "Test setSubtype(String); when 'Subtype'; then PDExternalDataDictionary() Subtype is 'Subtype'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDExternalDataDictionary.setSubtype(String)"})
  void testSetSubtype_whenSubtype_thenPDExternalDataDictionarySubtypeIsSubtype() {
    // Arrange
    PDExternalDataDictionary pdExternalDataDictionary = new PDExternalDataDictionary();

    // Act
    pdExternalDataDictionary.setSubtype("Subtype");

    // Assert
    assertEquals("Subtype", pdExternalDataDictionary.getSubtype());
    COSDictionary cOSObject = pdExternalDataDictionary.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
