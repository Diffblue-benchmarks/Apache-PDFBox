package org.apache.pdfbox.pdmodel.interactive.action;

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

class PDURIDictionaryDiffblueTest {
  /**
   * Test {@link PDURIDictionary#PDURIDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link PDURIDictionary#PDURIDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDURIDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDURIDictionary.<init>(COSDictionary)"})
  void testNewPDURIDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDURIDictionary(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDURIDictionary#PDURIDictionary()}.
   *
   * <p>Method under test: {@link PDURIDictionary#PDURIDictionary()}
   */
  @Test
  @DisplayName("Test new PDURIDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDURIDictionary.<init>()"})
  void testNewPDURIDictionary2() {
    // Arrange and Act
    PDURIDictionary actualPduriDictionary = new PDURIDictionary();

    // Assert
    assertNull(actualPduriDictionary.getBase());
    COSDictionary cOSObject = actualPduriDictionary.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDURIDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDURIDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDURIDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDURIDictionary().getCOSObject();

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
   * Test {@link PDURIDictionary#getBase()}.
   *
   * <ul>
   *   <li>Given {@link PDURIDictionary#PDURIDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDURIDictionary#getBase()}
   */
  @Test
  @DisplayName("Test getBase(); given PDURIDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDURIDictionary.getBase()"})
  void testGetBase_givenPDURIDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDURIDictionary().getBase());
  }

  /**
   * Test {@link PDURIDictionary#setBase(String)}.
   *
   * <ul>
   *   <li>Given {@link PDURIDictionary#PDURIDictionary()}.
   *   <li>When {@code Base}.
   *   <li>Then {@link PDURIDictionary#PDURIDictionary()} Base is {@code Base}.
   * </ul>
   *
   * <p>Method under test: {@link PDURIDictionary#setBase(String)}
   */
  @Test
  @DisplayName(
      "Test setBase(String); given PDURIDictionary(); when 'Base'; then PDURIDictionary() Base is 'Base'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDURIDictionary.setBase(String)"})
  void testSetBase_givenPDURIDictionary_whenBase_thenPDURIDictionaryBaseIsBase() {
    // Arrange
    PDURIDictionary pduriDictionary = new PDURIDictionary();

    // Act
    pduriDictionary.setBase("Base");

    // Assert
    assertEquals("Base", pduriDictionary.getBase());
    COSDictionary cOSObject = pduriDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDURIDictionary#setBase(String)}.
   *
   * <ul>
   *   <li>Given {@link PDURIDictionary#PDURIDictionary()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDURIDictionary#PDURIDictionary()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDURIDictionary#setBase(String)}
   */
  @Test
  @DisplayName(
      "Test setBase(String); given PDURIDictionary(); when 'null'; then PDURIDictionary() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDURIDictionary.setBase(String)"})
  void testSetBase_givenPDURIDictionary_whenNull_thenPDURIDictionaryCOSObjectSizeIsZero() {
    // Arrange
    PDURIDictionary pduriDictionary = new PDURIDictionary();

    // Act
    pduriDictionary.setBase(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pduriDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }
}
