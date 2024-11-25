package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDActionNamedDiffblueTest {
  /**
   * Test {@link PDActionNamed#PDActionNamed(COSDictionary)}.
   * <p>
   * Method under test: {@link PDActionNamed#PDActionNamed(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDActionNamed(COSDictionary)")
  void testNewPDActionNamed() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionNamed(a)).getCOSObject());
  }

  /**
   * Test {@link PDActionNamed#PDActionNamed()}.
   * <p>
   * Method under test: {@link PDActionNamed#PDActionNamed()}
   */
  @Test
  @DisplayName("Test new PDActionNamed()")
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
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()} N is {@code N}.</li>
   *   <li>Then return {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionNamed#getN()}
   */
  @Test
  @DisplayName("Test getN(); given PDActionNamed() N is 'N'; then return 'N'")
  void testGetN_givenPDActionNamedNIsN_thenReturnN() {
    // Arrange
    PDActionNamed pdActionNamed = new PDActionNamed();
    pdActionNamed.setN("N");

    // Act and Assert
    assertEquals("N", pdActionNamed.getN());
  }

  /**
   * Test {@link PDActionNamed#getN()}.
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed(COSDictionary)} with a is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionNamed#getN()}
   */
  @Test
  @DisplayName("Test getN(); given PDActionNamed(COSDictionary) with a is COSDictionary(); then return 'null'")
  void testGetN_givenPDActionNamedWithAIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionNamed(new COSDictionary())).getN());
  }

  /**
   * Test {@link PDActionNamed#getN()}.
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionNamed#getN()}
   */
  @Test
  @DisplayName("Test getN(); given PDActionNamed(); then return 'null'")
  void testGetN_givenPDActionNamed_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDActionNamed()).getN());
  }

  /**
   * Test {@link PDActionNamed#setN(String)}.
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>When {@code Name42}.</li>
   *   <li>Then {@link PDActionNamed#PDActionNamed()} N is {@code Name42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionNamed#setN(String)}
   */
  @Test
  @DisplayName("Test setN(String); given PDActionNamed(); when 'Name42'; then PDActionNamed() N is 'Name42'")
  void testSetN_givenPDActionNamed_whenName42_thenPDActionNamedNIsName42() {
    // Arrange
    PDActionNamed pdActionNamed = new PDActionNamed();

    // Act
    pdActionNamed.setN("Name42");

    // Assert
    assertEquals("Name42", pdActionNamed.getN());
    COSDictionary cOSObject = pdActionNamed.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDActionNamed#setN(String)}.
   * <ul>
   *   <li>Given {@link PDActionNamed#PDActionNamed()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDActionNamed#PDActionNamed()} N is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDActionNamed#setN(String)}
   */
  @Test
  @DisplayName("Test setN(String); given PDActionNamed(); when 'Name'; then PDActionNamed() N is 'Name'")
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
}
