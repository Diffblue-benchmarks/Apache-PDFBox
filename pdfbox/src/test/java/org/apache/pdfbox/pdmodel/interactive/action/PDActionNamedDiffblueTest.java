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

class PDActionNamedDiffblueTest {
  /**
   * Test {@link PDActionNamed#PDActionNamed(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionNamed#PDActionNamed(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionNamed(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionNamed.<init>(COSDictionary)"})
  void testNewPDActionNamed() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionNamed(a).getCOSObject());
  }

  /**
   * Test {@link PDActionNamed#PDActionNamed()}.
   *
   * <p>Method under test: {@link PDActionNamed#PDActionNamed()}
   */
  @Test
  @DisplayName("Test new PDActionNamed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionNamed.<init>()"})
  void testNewPDActionNamed2() {
    // Arrange and Act
    PDActionNamed actualPdActionNamed = new PDActionNamed();

    // Assert
    assertNull(actualPdActionNamed.getN());
    assertNull(actualPdActionNamed.getNext());
    COSDictionary cOSObject = actualPdActionNamed.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionNamed.getType());
    assertEquals(PDActionNamed.SUB_TYPE, actualPdActionNamed.getSubType());
  }

  /**
   * Test {@link PDActionNamed#getN()}.
   *
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()} N is {@code N}.
   *   <li>Then return {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionNamed#getN()}
   */
  @Test
  @DisplayName("Test getN(); given PDActionNamed() N is 'N'; then return 'N'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionNamed.getN()"})
  void testGetN_givenPDActionNamedNIsN_thenReturnN() {
    // Arrange
    PDActionNamed pdActionNamed = new PDActionNamed();
    pdActionNamed.setN("N");

    // Act and Assert
    assertEquals("N", pdActionNamed.getN());
  }

  /**
   * Test {@link PDActionNamed#getN()}.
   *
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionNamed#getN()}
   */
  @Test
  @DisplayName(
      "Test getN(); given PDActionNamed(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionNamed.getN()"})
  void testGetN_givenPDActionNamedWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionNamed(new COSDictionary()).getN());
  }

  /**
   * Test {@link PDActionNamed#getN()}.
   *
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionNamed#getN()}
   */
  @Test
  @DisplayName("Test getN(); given PDActionNamed(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionNamed.getN()"})
  void testGetN_givenPDActionNamed_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionNamed().getN());
  }

  /**
   * Test {@link PDActionNamed#setN(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.
   *   <li>When {@code 42}.
   *   <li>Then {@link PDActionNamed#PDActionNamed()} N is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionNamed#setN(String)}
   */
  @Test
  @DisplayName(
      "Test setN(String); given PDActionNamed(); when '42'; then PDActionNamed() N is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionNamed.setN(String)"})
  void testSetN_givenPDActionNamed_when42_thenPDActionNamedNIs42() {
    // Arrange
    PDActionNamed pdActionNamed = new PDActionNamed();

    // Act
    pdActionNamed.setN("42");

    // Assert
    assertEquals("42", pdActionNamed.getN());
    COSDictionary cOSObject = pdActionNamed.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionNamed#setN(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.
   *   <li>When {@code Name}.
   *   <li>Then {@link PDActionNamed#PDActionNamed()} N is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionNamed#setN(String)}
   */
  @Test
  @DisplayName(
      "Test setN(String); given PDActionNamed(); when 'Name'; then PDActionNamed() N is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionNamed.setN(String)"})
  void testSetN_givenPDActionNamed_whenName_thenPDActionNamedNIsName() {
    // Arrange
    PDActionNamed pdActionNamed = new PDActionNamed();

    // Act
    pdActionNamed.setN("Name");

    // Assert
    assertEquals("Name", pdActionNamed.getN());
    COSDictionary cOSObject = pdActionNamed.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionNamed#setN(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionNamed#PDActionNamed()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionNamed#setN(String)}
   */
  @Test
  @DisplayName(
      "Test setN(String); given PDActionNamed(); when 'null'; then PDActionNamed() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionNamed.setN(String)"})
  void testSetN_givenPDActionNamed_whenNull_thenPDActionNamedCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionNamed pdActionNamed = new PDActionNamed();

    // Act
    pdActionNamed.setN(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionNamed.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
