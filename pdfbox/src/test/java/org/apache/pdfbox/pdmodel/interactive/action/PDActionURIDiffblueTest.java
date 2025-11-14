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

class PDActionURIDiffblueTest {
  /**
   * Test {@link PDActionURI#PDActionURI(COSDictionary)}.
   *
   * <p>Method under test: {@link PDActionURI#PDActionURI(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionURI(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionURI.<init>(COSDictionary)"})
  void testNewPDActionURI() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, new PDActionURI(a).getCOSObject());
  }

  /**
   * Test {@link PDActionURI#PDActionURI()}.
   *
   * <p>Method under test: {@link PDActionURI#PDActionURI()}
   */
  @Test
  @DisplayName("Test new PDActionURI()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionURI.<init>()"})
  void testNewPDActionURI2() {
    // Arrange and Act
    PDActionURI actualPdActionURI = new PDActionURI();

    // Assert
    assertNull(actualPdActionURI.getURI());
    assertNull(actualPdActionURI.getNext());
    COSDictionary cOSObject = actualPdActionURI.getCOSObject();
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
    assertEquals(PDAction.TYPE, actualPdActionURI.getType());
    assertEquals(PDActionURI.SUB_TYPE, actualPdActionURI.getSubType());
  }

  /**
   * Test {@link PDActionURI#getURI()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()} URI is empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDActionURI() URI is empty string; then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionURI.getURI()"})
  void testGetURI_givenPDActionURIUriIsEmptyString_thenReturnEmptyString() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setURI("");

    // Act and Assert
    assertEquals("", pdActionURI.getURI());
  }

  /**
   * Test {@link PDActionURI#getURI()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()} URI is {@code Uri}.
   *   <li>Then return {@code Uri}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDActionURI() URI is 'Uri'; then return 'Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionURI.getURI()"})
  void testGetURI_givenPDActionURIUriIsUri_thenReturnUri() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setURI("Uri");

    // Act and Assert
    assertEquals("Uri", pdActionURI.getURI());
  }

  /**
   * Test {@link PDActionURI#getURI()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName(
      "Test getURI(); given PDActionURI(COSDictionary) with a is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionURI.getURI()"})
  void testGetURI_givenPDActionURIWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionURI(new COSDictionary()).getURI());
  }

  /**
   * Test {@link PDActionURI#getURI()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDActionURI(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDActionURI.getURI()"})
  void testGetURI_givenPDActionURI_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDActionURI().getURI());
  }

  /**
   * Test {@link PDActionURI#setURI(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.
   *   <li>When {@code null}.
   *   <li>Then {@link PDActionURI#PDActionURI()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#setURI(String)}
   */
  @Test
  @DisplayName(
      "Test setURI(String); given PDActionURI(); when 'null'; then PDActionURI() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionURI.setURI(String)"})
  void testSetURI_givenPDActionURI_whenNull_thenPDActionURICOSObjectValuesSizeIsTwo() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setURI(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDActionURI#setURI(String)}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.
   *   <li>When {@code Uri}.
   *   <li>Then {@link PDActionURI#PDActionURI()} URI is {@code Uri}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#setURI(String)}
   */
  @Test
  @DisplayName(
      "Test setURI(String); given PDActionURI(); when 'Uri'; then PDActionURI() URI is 'Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionURI.setURI(String)"})
  void testSetURI_givenPDActionURI_whenUri_thenPDActionURIUriIsUri() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setURI("Uri");

    // Assert
    assertEquals("Uri", pdActionURI.getURI());
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionURI#shouldTrackMousePosition()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()} TrackMousePosition is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName("Test shouldTrackMousePosition(); given PDActionURI() TrackMousePosition is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionURI.shouldTrackMousePosition()"})
  void testShouldTrackMousePosition_givenPDActionURITrackMousePositionIsFalse() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setTrackMousePosition(false);

    // Act and Assert
    assertFalse(pdActionURI.shouldTrackMousePosition());
  }

  /**
   * Test {@link PDActionURI#shouldTrackMousePosition()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI(COSDictionary)} with a is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName(
      "Test shouldTrackMousePosition(); given PDActionURI(COSDictionary) with a is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionURI.shouldTrackMousePosition()"})
  void testShouldTrackMousePosition_givenPDActionURIWithAIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDActionURI(new COSDictionary()).shouldTrackMousePosition());
  }

  /**
   * Test {@link PDActionURI#shouldTrackMousePosition()}.
   *
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName("Test shouldTrackMousePosition(); given PDActionURI(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionURI.shouldTrackMousePosition()"})
  void testShouldTrackMousePosition_givenPDActionURI_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDActionURI().shouldTrackMousePosition());
  }

  /**
   * Test {@link PDActionURI#shouldTrackMousePosition()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName("Test shouldTrackMousePosition(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDActionURI.shouldTrackMousePosition()"})
  void testShouldTrackMousePosition_thenReturnTrue() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();
    pdActionURI.setTrackMousePosition(true);

    // Act and Assert
    assertTrue(pdActionURI.shouldTrackMousePosition());
  }

  /**
   * Test {@link PDActionURI#setTrackMousePosition(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDActionURI#PDActionURI()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  @DisplayName(
      "Test setTrackMousePosition(boolean); then PDActionURI() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionURI.setTrackMousePosition(boolean)"})
  void testSetTrackMousePosition_thenPDActionURICOSObjectValuesSizeIsThree() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setTrackMousePosition(true);

    // Assert
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionURI#setTrackMousePosition(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link PDActionURI#PDActionURI()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  @DisplayName(
      "Test setTrackMousePosition(boolean); when 'false'; then PDActionURI() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDActionURI.setTrackMousePosition(boolean)"})
  void testSetTrackMousePosition_whenFalse_thenPDActionURICOSObjectValuesSizeIsThree() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI();

    // Act
    pdActionURI.setTrackMousePosition(false);

    // Assert
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
