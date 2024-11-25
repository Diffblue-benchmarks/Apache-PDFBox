package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDTransitionDiffblueTest {
  /**
   * Test {@link PDTransition#PDTransition(COSDictionary)}.
   * <p>
   * Method under test: {@link PDTransition#PDTransition(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTransition(COSDictionary)")
  void testNewPDTransition() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDTransition(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDTransition#PDTransition()}.
   * <p>
   * Method under test: {@link PDTransition#PDTransition()}
   */
  @Test
  @DisplayName("Test new PDTransition()")
  void testNewPDTransition2() {
    // Arrange and Act
    PDTransition actualPdTransition = new PDTransition();

    // Assert
    COSBase direction = actualPdTransition.getDirection();
    assertTrue(direction instanceof COSInteger);
    assertEquals("H", actualPdTransition.getDimension());
    assertEquals("I", actualPdTransition.getMotion());
    assertEquals("R", actualPdTransition.getStyle());
    COSDictionary cOSObject = actualPdTransition.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(direction.getKey());
    assertEquals(1.0f, actualPdTransition.getDuration());
    assertEquals(1.0f, actualPdTransition.getFlyScale());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(direction.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdTransition.isFlyAreaOpaque());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) direction).isValid());
  }

  /**
   * Test {@link PDTransition#PDTransition(PDTransitionStyle)}.
   * <ul>
   *   <li>When {@code Blinds}.</li>
   *   <li>Then return Style is {@code Blinds}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#PDTransition(PDTransitionStyle)}
   */
  @Test
  @DisplayName("Test new PDTransition(PDTransitionStyle); when 'Blinds'; then return Style is 'Blinds'")
  void testNewPDTransition_whenBlinds_thenReturnStyleIsBlinds() {
    // Arrange and Act
    PDTransition actualPdTransition = new PDTransition(PDTransitionStyle.Blinds);

    // Assert
    COSBase direction = actualPdTransition.getDirection();
    assertTrue(direction instanceof COSInteger);
    assertEquals("Blinds", actualPdTransition.getStyle());
    assertEquals("H", actualPdTransition.getDimension());
    assertEquals("I", actualPdTransition.getMotion());
    COSDictionary cOSObject = actualPdTransition.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(direction.getKey());
    assertEquals(1.0f, actualPdTransition.getDuration());
    assertEquals(1.0f, actualPdTransition.getFlyScale());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(direction.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdTransition.isFlyAreaOpaque());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) direction).isValid());
  }

  /**
   * Test {@link PDTransition#PDTransition(PDTransitionStyle)}.
   * <ul>
   *   <li>When {@code Split}.</li>
   *   <li>Then return Style is {@code Split}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#PDTransition(PDTransitionStyle)}
   */
  @Test
  @DisplayName("Test new PDTransition(PDTransitionStyle); when 'Split'; then return Style is 'Split'")
  void testNewPDTransition_whenSplit_thenReturnStyleIsSplit() {
    // Arrange and Act
    PDTransition actualPdTransition = new PDTransition(PDTransitionStyle.Split);

    // Assert
    COSBase direction = actualPdTransition.getDirection();
    assertTrue(direction instanceof COSInteger);
    assertEquals("H", actualPdTransition.getDimension());
    assertEquals("I", actualPdTransition.getMotion());
    assertEquals("Split", actualPdTransition.getStyle());
    COSDictionary cOSObject = actualPdTransition.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(direction.getKey());
    assertEquals(1.0f, actualPdTransition.getDuration());
    assertEquals(1.0f, actualPdTransition.getFlyScale());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(direction.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdTransition.isFlyAreaOpaque());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) direction).isValid());
  }

  /**
   * Test {@link PDTransition#getStyle()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code R}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return 'R'")
  void testGetStyle_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnR() {
    // Arrange, Act and Assert
    assertEquals("R", (new PDTransition(new COSDictionary())).getStyle());
  }

  /**
   * Test {@link PDTransition#getStyle()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@code R}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDTransition(); then return 'R'")
  void testGetStyle_givenPDTransition_thenReturnR() {
    // Arrange, Act and Assert
    assertEquals("R", (new PDTransition()).getStyle());
  }

  /**
   * Test {@link PDTransition#getDimension()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code H}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getDimension()}
   */
  @Test
  @DisplayName("Test getDimension(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return 'H'")
  void testGetDimension_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnH() {
    // Arrange, Act and Assert
    assertEquals("H", (new PDTransition(new COSDictionary())).getDimension());
  }

  /**
   * Test {@link PDTransition#getDimension()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@code H}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getDimension()}
   */
  @Test
  @DisplayName("Test getDimension(); given PDTransition(); then return 'H'")
  void testGetDimension_givenPDTransition_thenReturnH() {
    // Arrange, Act and Assert
    assertEquals("H", (new PDTransition()).getDimension());
  }

  /**
   * Test {@link PDTransition#setDimension(PDTransitionDimension)}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setDimension(PDTransitionDimension)}
   */
  @Test
  @DisplayName("Test setDimension(PDTransitionDimension); given PDTransition(); then PDTransition() COSObject Values size is three")
  void testSetDimension_givenPDTransition_thenPDTransitionCOSObjectValuesSizeIsThree() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDimension(PDTransitionDimension.H);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#getMotion()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code I}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getMotion()}
   */
  @Test
  @DisplayName("Test getMotion(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return 'I'")
  void testGetMotion_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("I", (new PDTransition(new COSDictionary())).getMotion());
  }

  /**
   * Test {@link PDTransition#getMotion()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@code I}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getMotion()}
   */
  @Test
  @DisplayName("Test getMotion(); given PDTransition(); then return 'I'")
  void testGetMotion_givenPDTransition_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("I", (new PDTransition()).getMotion());
  }

  /**
   * Test {@link PDTransition#setMotion(PDTransitionMotion)}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} COSObject Values size is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setMotion(PDTransitionMotion)}
   */
  @Test
  @DisplayName("Test setMotion(PDTransitionMotion); given PDTransition(); then PDTransition() COSObject Values size is three")
  void testSetMotion_givenPDTransition_thenPDTransitionCOSObjectValuesSizeIsThree() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setMotion(PDTransitionMotion.I);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#getDirection()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@link COSInteger#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return ZERO")
  void testGetDirection_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnZero() {
    // Arrange and Act
    COSBase actualDirection = (new PDTransition(new COSDictionary())).getDirection();

    // Assert
    assertSame(((COSInteger) actualDirection).ZERO, actualDirection);
  }

  /**
   * Test {@link PDTransition#getDirection()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@link COSInteger#ZERO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given PDTransition(); then return ZERO")
  void testGetDirection_givenPDTransition_thenReturnZero() {
    // Arrange and Act
    COSBase actualDirection = (new PDTransition()).getDirection();

    // Assert
    assertSame(((COSInteger) actualDirection).ZERO, actualDirection);
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>When {@code NONE}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} Direction {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName("Test setDirection(PDTransitionDirection); given PDTransition(); when 'NONE'; then PDTransition() Direction COSName")
  void testSetDirection_givenPDTransition_whenNone_thenPDTransitionDirectionCOSName() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.NONE);

    // Assert
    COSBase direction = pdTransition.getDirection();
    assertTrue(direction instanceof COSName);
    assertEquals("None", ((COSName) direction).getName());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((COSName) direction).isEmpty());
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   * <ul>
   *   <li>When {@code BOTTOM_TO_TOP}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} Direction
   * {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName("Test setDirection(PDTransitionDirection); when 'BOTTOM_TO_TOP'; then PDTransition() Direction COSInteger")
  void testSetDirection_whenBottomToTop_thenPDTransitionDirectionCOSInteger() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.BOTTOM_TO_TOP);

    // Assert
    assertTrue(pdTransition.getDirection() instanceof COSInteger);
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   * <ul>
   *   <li>When {@code LEFT_TO_RIGHT}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} Direction
   * {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName("Test setDirection(PDTransitionDirection); when 'LEFT_TO_RIGHT'; then PDTransition() Direction COSInteger")
  void testSetDirection_whenLeftToRight_thenPDTransitionDirectionCOSInteger() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.LEFT_TO_RIGHT);

    // Assert
    assertTrue(pdTransition.getDirection() instanceof COSInteger);
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   * <ul>
   *   <li>When {@code TOP_TO_BOTTOM}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} Direction
   * {@link COSInteger}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName("Test setDirection(PDTransitionDirection); when 'TOP_TO_BOTTOM'; then PDTransition() Direction COSInteger")
  void testSetDirection_whenTopToBottom_thenPDTransitionDirectionCOSInteger() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.TOP_TO_BOTTOM);

    // Assert
    assertTrue(pdTransition.getDirection() instanceof COSInteger);
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#getDuration()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getDuration()}
   */
  @Test
  @DisplayName("Test getDuration(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return one")
  void testGetDuration_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDTransition(new COSDictionary())).getDuration());
  }

  /**
   * Test {@link PDTransition#getDuration()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getDuration()}
   */
  @Test
  @DisplayName("Test getDuration(); given PDTransition(); then return one")
  void testGetDuration_givenPDTransition_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDTransition()).getDuration());
  }

  /**
   * Test {@link PDTransition#setDuration(float)}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} Duration is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setDuration(float)}
   */
  @Test
  @DisplayName("Test setDuration(float); given PDTransition(); then PDTransition() Duration is ten")
  void testSetDuration_givenPDTransition_thenPDTransitionDurationIsTen() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDuration(10.0f);

    // Assert
    assertEquals(10.0f, pdTransition.getDuration());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#getFlyScale()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getFlyScale()}
   */
  @Test
  @DisplayName("Test getFlyScale(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return one")
  void testGetFlyScale_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDTransition(new COSDictionary())).getFlyScale());
  }

  /**
   * Test {@link PDTransition#getFlyScale()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#getFlyScale()}
   */
  @Test
  @DisplayName("Test getFlyScale(); given PDTransition(); then return one")
  void testGetFlyScale_givenPDTransition_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDTransition()).getFlyScale());
  }

  /**
   * Test {@link PDTransition#setFlyScale(float)}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} FlyScale is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setFlyScale(float)}
   */
  @Test
  @DisplayName("Test setFlyScale(float); given PDTransition(); then PDTransition() FlyScale is ten")
  void testSetFlyScale_givenPDTransition_thenPDTransitionFlyScaleIsTen() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setFlyScale(10.0f);

    // Assert
    assertEquals(10.0f, pdTransition.getFlyScale());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#isFlyAreaOpaque()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#isFlyAreaOpaque()}
   */
  @Test
  @DisplayName("Test isFlyAreaOpaque(); given PDTransition(COSDictionary) with dictionary is COSDictionary()")
  void testIsFlyAreaOpaque_givenPDTransitionWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDTransition(new COSDictionary())).isFlyAreaOpaque());
  }

  /**
   * Test {@link PDTransition#isFlyAreaOpaque()}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#isFlyAreaOpaque()}
   */
  @Test
  @DisplayName("Test isFlyAreaOpaque(); given PDTransition(); then return 'false'")
  void testIsFlyAreaOpaque_givenPDTransition_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDTransition()).isFlyAreaOpaque());
  }

  /**
   * Test {@link PDTransition#setFlyAreaOpaque(boolean)}.
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link PDTransition#PDTransition()} FlyAreaOpaque.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setFlyAreaOpaque(boolean)}
   */
  @Test
  @DisplayName("Test setFlyAreaOpaque(boolean); given PDTransition(); when 'true'; then PDTransition() FlyAreaOpaque")
  void testSetFlyAreaOpaque_givenPDTransition_whenTrue_thenPDTransitionFlyAreaOpaque() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setFlyAreaOpaque(true);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(pdTransition.isFlyAreaOpaque());
  }

  /**
   * Test {@link PDTransition#setFlyAreaOpaque(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then not {@link PDTransition#PDTransition()} FlyAreaOpaque.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTransition#setFlyAreaOpaque(boolean)}
   */
  @Test
  @DisplayName("Test setFlyAreaOpaque(boolean); when 'false'; then not PDTransition() FlyAreaOpaque")
  void testSetFlyAreaOpaque_whenFalse_thenNotPDTransitionFlyAreaOpaque() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setFlyAreaOpaque(false);

    // Assert
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(pdTransition.isFlyAreaOpaque());
  }
}
