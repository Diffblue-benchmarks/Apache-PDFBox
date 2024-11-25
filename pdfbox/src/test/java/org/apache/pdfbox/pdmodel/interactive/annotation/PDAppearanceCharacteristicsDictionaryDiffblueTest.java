package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAppearanceCharacteristicsDictionaryDiffblueTest {
  /**
   * Test
   * {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAppearanceCharacteristicsDictionary(COSDictionary)")
  void testNewPDAppearanceCharacteristicsDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDAppearanceCharacteristicsDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDAppearanceCharacteristicsDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRotation()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation()")
  void testGetRotation() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRotation()}.
   * <ul>
   *   <li>Given
   * {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   * with dict is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); given PDAppearanceCharacteristicsDictionary(COSDictionary) with dict is COSStream()")
  void testGetRotation_givenPDAppearanceCharacteristicsDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAppearanceCharacteristicsDictionary(new COSStream())).getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  void testSetRotation() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setRotation(1);

    // Assert
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdAppearanceCharacteristicsDictionary.getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  void testSetRotation2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setRotation(-100);

    // Assert
    assertEquals(-100, pdAppearanceCharacteristicsDictionary.getRotation());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  void testSetRotation3() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setRotation(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdAppearanceCharacteristicsDictionary.getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}
   */
  @Test
  @DisplayName("Test getBorderColour()")
  void testGetBorderColour() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getBorderColour());
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getBorderColour());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  void testSetBorderColour() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  void testSetBorderColour2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor borderColour = pdAppearanceCharacteristicsDictionary.getBorderColour();
    assertNull(borderColour.getPatternName());
    assertFalse(borderColour.isPattern());
    assertArrayEquals(new float[]{0.0f}, borderColour.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  void testSetBorderColour3() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor borderColour = pdAppearanceCharacteristicsDictionary.getBorderColour();
    assertTrue(borderColour.isPattern());
    assertArrayEquals(new float[]{0.0f}, borderColour.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getBackground()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground()")
  void testGetBackground() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getBackground());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getBackground()}.
   * <ul>
   *   <li>Given
   * {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   * with dict is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground(); given PDAppearanceCharacteristicsDictionary(COSDictionary) with dict is COSStream()")
  void testGetBackground_givenPDAppearanceCharacteristicsDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getBackground());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  void testSetBackground() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  void testSetBackground2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor background = pdAppearanceCharacteristicsDictionary.getBackground();
    assertNull(background.getPatternName());
    assertFalse(background.isPattern());
    assertArrayEquals(new float[]{0.0f}, background.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  void testSetBackground3() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor background = pdAppearanceCharacteristicsDictionary.getBackground();
    assertTrue(background.isPattern());
    assertArrayEquals(new float[]{0.0f}, background.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}
   */
  @Test
  @DisplayName("Test getNormalCaption()")
  void testGetNormalCaption() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getNormalCaption());
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getNormalCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}
   */
  @Test
  @DisplayName("Test setNormalCaption(String)")
  void testSetNormalCaption() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setNormalCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getNormalCaption());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}
   */
  @Test
  @DisplayName("Test getRolloverCaption()")
  void testGetRolloverCaption() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRolloverCaption());
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getRolloverCaption());
  }

  /**
   * Test
   * {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}
   */
  @Test
  @DisplayName("Test setRolloverCaption(String)")
  void testSetRolloverCaption() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setRolloverCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getRolloverCaption());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}
   */
  @Test
  @DisplayName("Test getAlternateCaption()")
  void testGetAlternateCaption() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getAlternateCaption());
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getAlternateCaption());
  }

  /**
   * Test
   * {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}
   */
  @Test
  @DisplayName("Test setAlternateCaption(String)")
  void testSetAlternateCaption() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setAlternateCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getAlternateCaption());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}
   */
  @Test
  @DisplayName("Test getNormalIcon()")
  void testGetNormalIcon() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getNormalIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}.
   * <ul>
   *   <li>Given
   * {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   * with dict is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}
   */
  @Test
  @DisplayName("Test getNormalIcon(); given PDAppearanceCharacteristicsDictionary(COSDictionary) with dict is COSStream()")
  void testGetNormalIcon_givenPDAppearanceCharacteristicsDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getNormalIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}
   */
  @Test
  @DisplayName("Test getRolloverIcon()")
  void testGetRolloverIcon() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRolloverIcon());
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getRolloverIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}.
   * <p>
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}
   */
  @Test
  @DisplayName("Test getAlternateIcon()")
  void testGetAlternateIcon() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getAlternateIcon());
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSStream())).getAlternateIcon());
  }
}
