package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.Test;

class PDAppearanceCharacteristicsDictionaryDiffblueTest {
  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDAppearanceCharacteristicsDictionary(dict)).getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRotation()}
   */
  @Test
  void testGetRotation() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRotation());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  void testSetRotation() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setRotation(1);

    // Assert
    assertEquals(1, pdAppearanceCharacteristicsDictionary.getRotation());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  void testSetRotation2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setRotation(-100);

    // Assert
    assertEquals(-100, pdAppearanceCharacteristicsDictionary.getRotation());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  void testSetRotation3() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setRotation(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdAppearanceCharacteristicsDictionary.getRotation());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}
   */
  @Test
  void testGetBorderColour() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getBorderColour());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  void testSetBorderColour() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertNull(pdAppearanceCharacteristicsDictionary.getBorderColour());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  void testSetBorderColour2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor borderColour = pdAppearanceCharacteristicsDictionary.getBorderColour();
    assertNull(borderColour.getPatternName());
    assertFalse(borderColour.isPattern());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
    assertArrayEquals(new float[]{0.0f}, borderColour.getComponents(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  void testSetBorderColour3() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    assertNull(pdAppearanceCharacteristicsDictionary.getBorderColour());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  void testSetBorderColour4() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    assertNull(pdAppearanceCharacteristicsDictionary.getBorderColour());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getBackground()}
   */
  @Test
  void testGetBackground() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getBackground());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  void testSetBackground() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    assertNull(pdAppearanceCharacteristicsDictionary.getBackground());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  void testSetBackground2() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor background = pdAppearanceCharacteristicsDictionary.getBackground();
    assertNull(background.getPatternName());
    assertFalse(background.isPattern());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
    assertArrayEquals(new float[]{0.0f}, background.getComponents(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  void testSetBackground3() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    assertNull(pdAppearanceCharacteristicsDictionary.getBackground());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  void testSetBackground4() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    assertNull(pdAppearanceCharacteristicsDictionary.getBackground());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}
   */
  @Test
  void testGetNormalCaption() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getNormalCaption());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}
   */
  @Test
  void testSetNormalCaption() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setNormalCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getNormalCaption());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}
   */
  @Test
  void testGetRolloverCaption() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRolloverCaption());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}
   */
  @Test
  void testSetRolloverCaption() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setRolloverCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getRolloverCaption());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}
   */
  @Test
  void testGetAlternateCaption() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getAlternateCaption());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}
   */
  @Test
  void testSetAlternateCaption() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary = new PDAppearanceCharacteristicsDictionary(
        dict);

    // Act
    pdAppearanceCharacteristicsDictionary.setAlternateCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getAlternateCaption());
    assertSame(dict, pdAppearanceCharacteristicsDictionary.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}
   */
  @Test
  void testGetNormalIcon() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getNormalIcon());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}
   */
  @Test
  void testGetRolloverIcon() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRolloverIcon());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}
   */
  @Test
  void testGetAlternateIcon() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getAlternateIcon());
  }

  /**
   * Method under test:
   * {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   */
  @Test
  void testNewPDAppearanceCharacteristicsDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDAppearanceCharacteristicsDictionary(dict)).getCOSObject());
  }
}
