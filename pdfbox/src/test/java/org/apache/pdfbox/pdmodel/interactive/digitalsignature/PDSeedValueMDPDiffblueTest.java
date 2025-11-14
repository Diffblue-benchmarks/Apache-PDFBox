package org.apache.pdfbox.pdmodel.interactive.digitalsignature;

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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSeedValueMDPDiffblueTest {
  /**
   * Test {@link PDSeedValueMDP#PDSeedValueMDP()}.
   *
   * <p>Method under test: {@link PDSeedValueMDP#PDSeedValueMDP()}
   */
  @Test
  @DisplayName("Test new PDSeedValueMDP()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueMDP.<init>()"})
  void testNewPDSeedValueMDP() {
    // Arrange and Act
    PDSeedValueMDP actualPdSeedValueMDP = new PDSeedValueMDP();

    // Assert
    COSDictionary cOSObject = actualPdSeedValueMDP.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(-1, actualPdSeedValueMDP.getP());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
  }

  /**
   * Test {@link PDSeedValueMDP#PDSeedValueMDP(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return P is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#PDSeedValueMDP(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDSeedValueMDP(COSDictionary); when COSDictionary(); then return P is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueMDP.<init>(COSDictionary)"})
  void testNewPDSeedValueMDP_whenCOSDictionary_thenReturnPIsMinusOne() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDSeedValueMDP actualPdSeedValueMDP = new PDSeedValueMDP(dict);

    // Assert
    assertEquals(-1, actualPdSeedValueMDP.getP());
    assertTrue(dict.isDirect());
    assertSame(dict, actualPdSeedValueMDP.getCOSObject());
  }

  /**
   * Test {@link PDSeedValueMDP#getCOSObject()}.
   *
   * <p>Method under test: {@link PDSeedValueMDP#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDSeedValueMDP.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDSeedValueMDP().getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualCOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCOSObject.isDirect());
  }

  /**
   * Test {@link PDSeedValueMDP#getP()}.
   *
   * <ul>
   *   <li>Given {@link PDSeedValueMDP#PDSeedValueMDP(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} P is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#getP()}
   */
  @Test
  @DisplayName(
      "Test getP(); given PDSeedValueMDP(COSDictionary) with dict is COSDictionary() P is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDSeedValueMDP.getP()"})
  void testGetP_givenPDSeedValueMDPWithDictIsCOSDictionaryPIsOne_thenReturnOne() {
    // Arrange
    PDSeedValueMDP pdSeedValueMDP = new PDSeedValueMDP(new COSDictionary());
    pdSeedValueMDP.setP(1);

    // Act and Assert
    assertEquals(1, pdSeedValueMDP.getP());
  }

  /**
   * Test {@link PDSeedValueMDP#getP()}.
   *
   * <ul>
   *   <li>Given {@link PDSeedValueMDP#PDSeedValueMDP(COSDictionary)} with dict is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#getP()}
   */
  @Test
  @DisplayName(
      "Test getP(); given PDSeedValueMDP(COSDictionary) with dict is COSStream(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDSeedValueMDP.getP()"})
  void testGetP_givenPDSeedValueMDPWithDictIsCOSStream_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDSeedValueMDP(new COSStream()).getP());
  }

  /**
   * Test {@link PDSeedValueMDP#getP()}.
   *
   * <ul>
   *   <li>Given {@link PDSeedValueMDP#PDSeedValueMDP()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#getP()}
   */
  @Test
  @DisplayName("Test getP(); given PDSeedValueMDP(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDSeedValueMDP.getP()"})
  void testGetP_givenPDSeedValueMDP_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDSeedValueMDP().getP());
  }

  /**
   * Test {@link PDSeedValueMDP#setP(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#setP(int)}
   */
  @Test
  @DisplayName("Test setP(int); when four; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueMDP.setP(int)"})
  void testSetP_whenFour_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDSeedValueMDP().setP(4));
  }

  /**
   * Test {@link PDSeedValueMDP#setP(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#setP(int)}
   */
  @Test
  @DisplayName("Test setP(int); when minus one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueMDP.setP(int)"})
  void testSetP_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDSeedValueMDP().setP(-1));
  }

  /**
   * Test {@link PDSeedValueMDP#setP(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDSeedValueMDP#PDSeedValueMDP()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDSeedValueMDP#setP(int)}
   */
  @Test
  @DisplayName("Test setP(int); when one; then PDSeedValueMDP() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSeedValueMDP.setP(int)"})
  void testSetP_whenOne_thenPDSeedValueMDPCOSObjectValuesSizeIsOne() {
    // Arrange
    PDSeedValueMDP pdSeedValueMDP = new PDSeedValueMDP();

    // Act
    pdSeedValueMDP.setP(1);

    // Assert
    COSDictionary cOSObject = pdSeedValueMDP.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdSeedValueMDP.getP());
  }
}
