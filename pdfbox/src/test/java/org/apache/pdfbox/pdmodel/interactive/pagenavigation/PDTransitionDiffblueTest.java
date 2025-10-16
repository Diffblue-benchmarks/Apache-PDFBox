package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTransitionDiffblueTest {
  /**
   * Test {@link PDTransition#PDTransition(COSDictionary)}.
   *
   * <p>Method under test: {@link PDTransition#PDTransition(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDTransition(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.<init>(COSDictionary)"})
  void testNewPDTransition() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDTransition(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDTransition#getStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code R}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getStyle()}
   */
  @Test
  @DisplayName(
      "Test getStyle(); given PDTransition(COSDictionary) with dictionary is COSDictionary(); then return 'R'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTransition.getStyle()"})
  void testGetStyle_givenPDTransitionWithDictionaryIsCOSDictionary_thenReturnR() {
    // Arrange, Act and Assert
    assertEquals("R", new PDTransition(new COSDictionary()).getStyle());
  }

  /**
   * Test {@link PDTransition#getStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return {@code R}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getStyle()}
   */
  @Test
  @DisplayName("Test getStyle(); given PDTransition(); then return 'R'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTransition.getStyle()"})
  void testGetStyle_givenPDTransition_thenReturnR() {
    // Arrange, Act and Assert
    assertEquals("R", new PDTransition().getStyle());
  }

  /**
   * Test {@link PDTransition#getDimension()}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return {@code H}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getDimension()}
   */
  @Test
  @DisplayName("Test getDimension(); given PDTransition(); then return 'H'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTransition.getDimension()"})
  void testGetDimension_givenPDTransition_thenReturnH() {
    // Arrange, Act and Assert
    assertEquals("H", new PDTransition().getDimension());
  }

  /**
   * Test {@link PDTransition#setDimension(PDTransitionDimension)}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then {@link PDTransition#PDTransition()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setDimension(PDTransitionDimension)}
   */
  @Test
  @DisplayName(
      "Test setDimension(PDTransitionDimension); given PDTransition(); then PDTransition() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setDimension(PDTransitionDimension)"})
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
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return {@code I}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getMotion()}
   */
  @Test
  @DisplayName("Test getMotion(); given PDTransition(); then return 'I'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDTransition.getMotion()"})
  void testGetMotion_givenPDTransition_thenReturnI() {
    // Arrange, Act and Assert
    assertEquals("I", new PDTransition().getMotion());
  }

  /**
   * Test {@link PDTransition#setMotion(PDTransitionMotion)}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then {@link PDTransition#PDTransition()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setMotion(PDTransitionMotion)}
   */
  @Test
  @DisplayName(
      "Test setMotion(PDTransitionMotion); given PDTransition(); then PDTransition() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setMotion(PDTransitionMotion)"})
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
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return {@link COSInteger#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getDirection()}
   */
  @Test
  @DisplayName("Test getDirection(); given PDTransition(); then return ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDTransition.getDirection()"})
  void testGetDirection_givenPDTransition_thenReturnZero() {
    // Arrange and Act
    COSBase actualDirection = new PDTransition().getDirection();

    // Assert
    assertSame(((COSInteger) actualDirection).ZERO, actualDirection);
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>When {@code NONE}.
   *   <li>Then {@link PDTransition#PDTransition()} Direction {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName(
      "Test setDirection(PDTransitionDirection); given PDTransition(); when 'NONE'; then PDTransition() Direction COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setDirection(PDTransitionDirection)"})
  void testSetDirection_givenPDTransition_whenNone_thenPDTransitionDirectionCOSName() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.NONE);

    // Assert
    COSBase direction = pdTransition.getDirection();
    assertTrue(direction instanceof COSName);
    assertEquals("None", ((COSName) direction).getName());
    assertNull(direction.getKey());
    assertFalse(((COSName) direction).isEmpty());
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   *
   * <ul>
   *   <li>When {@code LEFT_TO_RIGHT}.
   *   <li>Then {@link PDTransition#PDTransition()} Direction {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName(
      "Test setDirection(PDTransitionDirection); when 'LEFT_TO_RIGHT'; then PDTransition() Direction COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setDirection(PDTransitionDirection)"})
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
   *
   * <ul>
   *   <li>When {@code RIGHT_TO_LEFT}.
   *   <li>Then {@link PDTransition#PDTransition()} Direction {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName(
      "Test setDirection(PDTransitionDirection); when 'RIGHT_TO_LEFT'; then PDTransition() Direction COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setDirection(PDTransitionDirection)"})
  void testSetDirection_whenRightToLeft_thenPDTransitionDirectionCOSInteger() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.RIGHT_TO_LEFT);

    // Assert
    COSBase direction = pdTransition.getDirection();
    assertTrue(direction instanceof COSInteger);
    assertNull(direction.getKey());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#setDirection(PDTransitionDirection)}.
   *
   * <ul>
   *   <li>When {@code TOP_TO_BOTTOM}.
   *   <li>Then {@link PDTransition#PDTransition()} Direction {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setDirection(PDTransitionDirection)}
   */
  @Test
  @DisplayName(
      "Test setDirection(PDTransitionDirection); when 'TOP_TO_BOTTOM'; then PDTransition() Direction COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setDirection(PDTransitionDirection)"})
  void testSetDirection_whenTopToBottom_thenPDTransitionDirectionCOSInteger() {
    // Arrange
    PDTransition pdTransition = new PDTransition();

    // Act
    pdTransition.setDirection(PDTransitionDirection.TOP_TO_BOTTOM);

    // Assert
    COSBase direction = pdTransition.getDirection();
    assertTrue(direction instanceof COSInteger);
    assertNull(direction.getKey());
    COSDictionary cOSObject = pdTransition.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTransition#getDuration()}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getDuration()}
   */
  @Test
  @DisplayName("Test getDuration(); given PDTransition(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTransition.getDuration()"})
  void testGetDuration_givenPDTransition_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDTransition().getDuration());
  }

  /**
   * Test {@link PDTransition#setDuration(float)}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then {@link PDTransition#PDTransition()} Duration is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setDuration(float)}
   */
  @Test
  @DisplayName("Test setDuration(float); given PDTransition(); then PDTransition() Duration is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setDuration(float)"})
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
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#getFlyScale()}
   */
  @Test
  @DisplayName("Test getFlyScale(); given PDTransition(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTransition.getFlyScale()"})
  void testGetFlyScale_givenPDTransition_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDTransition().getFlyScale());
  }

  /**
   * Test {@link PDTransition#setFlyScale(float)}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then {@link PDTransition#PDTransition()} FlyScale is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setFlyScale(float)}
   */
  @Test
  @DisplayName("Test setFlyScale(float); given PDTransition(); then PDTransition() FlyScale is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setFlyScale(float)"})
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
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#isFlyAreaOpaque()}
   */
  @Test
  @DisplayName("Test isFlyAreaOpaque(); given PDTransition(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDTransition.isFlyAreaOpaque()"})
  void testIsFlyAreaOpaque_givenPDTransition_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDTransition().isFlyAreaOpaque());
  }

  /**
   * Test {@link PDTransition#setFlyAreaOpaque(boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDTransition#PDTransition()}.
   *   <li>When {@code true}.
   *   <li>Then {@link PDTransition#PDTransition()} FlyAreaOpaque.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setFlyAreaOpaque(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlyAreaOpaque(boolean); given PDTransition(); when 'true'; then PDTransition() FlyAreaOpaque")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setFlyAreaOpaque(boolean)"})
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
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDTransition#PDTransition()} FlyAreaOpaque.
   * </ul>
   *
   * <p>Method under test: {@link PDTransition#setFlyAreaOpaque(boolean)}
   */
  @Test
  @DisplayName(
      "Test setFlyAreaOpaque(boolean); when 'false'; then not PDTransition() FlyAreaOpaque")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTransition.setFlyAreaOpaque(boolean)"})
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
