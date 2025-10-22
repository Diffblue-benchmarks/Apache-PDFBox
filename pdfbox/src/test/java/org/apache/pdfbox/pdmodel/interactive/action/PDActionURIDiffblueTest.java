package org.apache.pdfbox.pdmodel.interactive.action;

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

class PDActionURIDiffblueTest {
  /**
   * Test {@link PDActionURI#PDActionURI(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionURI#PDActionURI(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionURI(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionURI.<init>(COSDictionary)"})
  void testNewPDActionURI() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionURI(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionURI#PDActionURI()}.
   * <p>
   * Method under test: {@link PDActionURI#PDActionURI()}
   */
  @Test
  @DisplayName("Test new PDActionURI()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()} URI is empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDActionURI() URI is empty string; then return empty string")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()} URI is {@code Uri}.</li>
   *   <li>Then return {@code Uri}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDActionURI() URI is 'Uri'; then return 'Uri'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#getURI()}
   */
  @Test
  @DisplayName("Test getURI(); given PDActionURI(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDActionURI.getURI()"})
  void testGetURI_givenPDActionURI_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionURI()).getURI());
  }

  /**
   * Test {@link PDActionURI#setURI(String)}.
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then {@link PDActionURI#PDActionURI()} URI is {@code Uri}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#setURI(String)}
   */
  @Test
  @DisplayName("Test setURI(String); given PDActionURI(); then PDActionURI() URI is 'Uri'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionURI.setURI(String)"})
  void testSetURI_givenPDActionURI_thenPDActionURIUriIsUri() {
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
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()} TrackMousePosition is {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName("Test shouldTrackMousePosition(); given PDActionURI() TrackMousePosition is 'false'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDActionURI#PDActionURI()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName("Test shouldTrackMousePosition(); given PDActionURI(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDActionURI.shouldTrackMousePosition()"})
  void testShouldTrackMousePosition_givenPDActionURI_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDActionURI()).shouldTrackMousePosition());
  }

  /**
   * Test {@link PDActionURI#shouldTrackMousePosition()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#shouldTrackMousePosition()}
   */
  @Test
  @DisplayName("Test shouldTrackMousePosition(); then return 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  @DisplayName("Test setTrackMousePosition(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDActionURI.setTrackMousePosition(boolean)"})
  void testSetTrackMousePosition() {
    // Arrange
    PDActionURI pdActionURI = new PDActionURI(new COSDictionary());

    // Act
    pdActionURI.setTrackMousePosition(true);

    // Assert
    COSDictionary cOSObject = pdActionURI.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDActionURI#setTrackMousePosition(boolean)}.
   * <ul>
   *   <li>Then {@link PDActionURI#PDActionURI()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  @DisplayName("Test setTrackMousePosition(boolean); then PDActionURI() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link PDActionURI#PDActionURI()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionURI#setTrackMousePosition(boolean)}
   */
  @Test
  @DisplayName("Test setTrackMousePosition(boolean); when 'false'; then PDActionURI() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
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
