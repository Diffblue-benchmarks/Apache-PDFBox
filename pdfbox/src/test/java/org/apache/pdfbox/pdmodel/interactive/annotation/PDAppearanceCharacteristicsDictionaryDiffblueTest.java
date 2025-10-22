package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceCharacteristicsDictionaryDiffblueTest {
  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAppearanceCharacteristicsDictionary(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.<init>(COSDictionary)"})
  void testNewPDAppearanceCharacteristicsDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDAppearanceCharacteristicsDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDAppearanceCharacteristicsDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDAppearanceCharacteristicsDictionary(dict)).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRotation()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDAppearanceCharacteristicsDictionary.getRotation()"})
  void testGetRotation_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRotation(int)"})
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
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRotation(int)"})
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
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRotation(int)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}
   */
  @Test
  @DisplayName("Test getBorderColour(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColor PDAppearanceCharacteristicsDictionary.getBorderColour()"})
  void testGetBorderColour_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getBorderColour());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBorderColour(PDColor)"})
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
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBorderColour(PDColor)"})
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
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBorderColour(PDColor)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColor PDAppearanceCharacteristicsDictionary.getBackground()"})
  void testGetBackground_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getBackground());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBackground(PDColor)"})
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
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBackground(PDColor)"})
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
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBackground(PDColor)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}
   */
  @Test
  @DisplayName("Test getNormalCaption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getNormalCaption()"})
  void testGetNormalCaption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getNormalCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}
   */
  @Test
  @DisplayName("Test setNormalCaption(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setNormalCaption(String)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}
   */
  @Test
  @DisplayName("Test getRolloverCaption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getRolloverCaption()"})
  void testGetRolloverCaption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRolloverCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}
   */
  @Test
  @DisplayName("Test setRolloverCaption(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRolloverCaption(String)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}
   */
  @Test
  @DisplayName("Test getAlternateCaption(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getAlternateCaption()"})
  void testGetAlternateCaption_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getAlternateCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}.
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}
   */
  @Test
  @DisplayName("Test setAlternateCaption(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setAlternateCaption(String)"})
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}
   */
  @Test
  @DisplayName("Test getNormalIcon(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getNormalIcon()"})
  void testGetNormalIcon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getNormalIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}
   */
  @Test
  @DisplayName("Test getRolloverIcon(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getRolloverIcon()"})
  void testGetRolloverIcon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getRolloverIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}
   */
  @Test
  @DisplayName("Test getAlternateIcon(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getAlternateIcon()"})
  void testGetAlternateIcon_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDAppearanceCharacteristicsDictionary(new COSDictionary())).getAlternateIcon());
  }
}
