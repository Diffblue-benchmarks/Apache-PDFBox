package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAppearanceCharacteristicsDictionaryDiffblueTest {
  /**
   * Test {@link
   * PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAppearanceCharacteristicsDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.<init>(COSDictionary)"})
  void testNewPDAppearanceCharacteristicsDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDAppearanceCharacteristicsDictionary(dict).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDAppearanceCharacteristicsDictionary.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, new PDAppearanceCharacteristicsDictionary(dict).getCOSObject());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRotation()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getRotation()}
   */
  @Test
  @DisplayName("Test getRotation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAppearanceCharacteristicsDictionary.getRotation()"})
  void testGetRotation() {
    // Arrange, Act and Assert
    assertEquals(0, new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRotation()}.
   *
   * <ul>
   *   <li>Given {@link
   *       PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   *       with dict is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getRotation()}
   */
  @Test
  @DisplayName(
      "Test getRotation(); given PDAppearanceCharacteristicsDictionary(COSDictionary) with dict is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAppearanceCharacteristicsDictionary.getRotation()"})
  void testGetRotation_givenPDAppearanceCharacteristicsDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals(0, new PDAppearanceCharacteristicsDictionary(new COSStream()).getRotation());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRotation(int)"})
  void testSetRotation() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

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
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setRotation(int)}
   */
  @Test
  @DisplayName("Test setRotation(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRotation(int)"})
  void testSetRotation2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

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
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}
   */
  @Test
  @DisplayName("Test getBorderColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAppearanceCharacteristicsDictionary.getBorderColour()"})
  void testGetBorderColour() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getBorderColour());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getBorderColour()}
   */
  @Test
  @DisplayName("Test getBorderColour()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAppearanceCharacteristicsDictionary.getBorderColour()"})
  void testGetBorderColour2() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getBorderColour());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBorderColour(PDColor)"})
  void testSetBorderColour() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(
        new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setBorderColour(PDColor)}
   */
  @Test
  @DisplayName("Test setBorderColour(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBorderColour(PDColor)"})
  void testSetBorderColour2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBorderColour(
        new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor borderColour = pdAppearanceCharacteristicsDictionary.getBorderColour();
    assertTrue(borderColour.isPattern());
    assertArrayEquals(new float[] {0.0f}, borderColour.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getBackground()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAppearanceCharacteristicsDictionary.getBackground()"})
  void testGetBackground() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getBackground());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getBackground()}.
   *
   * <ul>
   *   <li>Given {@link
   *       PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   *       with dict is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getBackground()}
   */
  @Test
  @DisplayName(
      "Test getBackground(); given PDAppearanceCharacteristicsDictionary(COSDictionary) with dict is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAppearanceCharacteristicsDictionary.getBackground()"})
  void testGetBackground_givenPDAppearanceCharacteristicsDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getBackground());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBackground(PDColor)"})
  void testSetBackground() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(
        new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setBackground(PDColor)}
   */
  @Test
  @DisplayName("Test setBackground(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setBackground(PDColor)"})
  void testSetBackground2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setBackground(
        new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor background = pdAppearanceCharacteristicsDictionary.getBackground();
    assertTrue(background.isPattern());
    assertArrayEquals(new float[] {0.0f}, background.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}
   */
  @Test
  @DisplayName("Test getNormalCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getNormalCaption()"})
  void testGetNormalCaption() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getNormalCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getNormalCaption()}
   */
  @Test
  @DisplayName("Test getNormalCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getNormalCaption()"})
  void testGetNormalCaption2() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getNormalCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}
   */
  @Test
  @DisplayName("Test setNormalCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setNormalCaption(String)"})
  void testSetNormalCaption() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setNormalCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getNormalCaption());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setNormalCaption(String)}
   */
  @Test
  @DisplayName("Test setNormalCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setNormalCaption(String)"})
  void testSetNormalCaption2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setNormalCaption(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}
   */
  @Test
  @DisplayName("Test getRolloverCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getRolloverCaption()"})
  void testGetRolloverCaption() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getRolloverCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getRolloverCaption()}
   */
  @Test
  @DisplayName("Test getRolloverCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getRolloverCaption()"})
  void testGetRolloverCaption2() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getRolloverCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}
   */
  @Test
  @DisplayName("Test setRolloverCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRolloverCaption(String)"})
  void testSetRolloverCaption() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setRolloverCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getRolloverCaption());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setRolloverCaption(String)}
   */
  @Test
  @DisplayName("Test setRolloverCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setRolloverCaption(String)"})
  void testSetRolloverCaption2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setRolloverCaption(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}
   */
  @Test
  @DisplayName("Test getAlternateCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getAlternateCaption()"})
  void testGetAlternateCaption() {
    // Arrange, Act and Assert
    assertNull(
        new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getAlternateCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getAlternateCaption()}
   */
  @Test
  @DisplayName("Test getAlternateCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAppearanceCharacteristicsDictionary.getAlternateCaption()"})
  void testGetAlternateCaption2() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getAlternateCaption());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}
   */
  @Test
  @DisplayName("Test setAlternateCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setAlternateCaption(String)"})
  void testSetAlternateCaption() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setAlternateCaption("Caption");

    // Assert
    assertEquals("Caption", pdAppearanceCharacteristicsDictionary.getAlternateCaption());
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#setAlternateCaption(String)}
   */
  @Test
  @DisplayName("Test setAlternateCaption(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAppearanceCharacteristicsDictionary.setAlternateCaption(String)"})
  void testSetAlternateCaption2() {
    // Arrange
    PDAppearanceCharacteristicsDictionary pdAppearanceCharacteristicsDictionary =
        new PDAppearanceCharacteristicsDictionary(new COSDictionary());

    // Act
    pdAppearanceCharacteristicsDictionary.setAlternateCaption(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAppearanceCharacteristicsDictionary.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}
   */
  @Test
  @DisplayName("Test getNormalIcon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getNormalIcon()"
  })
  void testGetNormalIcon() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getNormalIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}.
   *
   * <ul>
   *   <li>Given {@link
   *       PDAppearanceCharacteristicsDictionary#PDAppearanceCharacteristicsDictionary(COSDictionary)}
   *       with dict is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getNormalIcon()}
   */
  @Test
  @DisplayName(
      "Test getNormalIcon(); given PDAppearanceCharacteristicsDictionary(COSDictionary) with dict is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getNormalIcon()"
  })
  void testGetNormalIcon_givenPDAppearanceCharacteristicsDictionaryWithDictIsCOSStream() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getNormalIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}
   */
  @Test
  @DisplayName("Test getRolloverIcon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getRolloverIcon()"
  })
  void testGetRolloverIcon() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getRolloverIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getRolloverIcon()}
   */
  @Test
  @DisplayName("Test getRolloverIcon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getRolloverIcon()"
  })
  void testGetRolloverIcon2() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getRolloverIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}
   */
  @Test
  @DisplayName("Test getAlternateIcon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getAlternateIcon()"
  })
  void testGetAlternateIcon() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSDictionary()).getAlternateIcon());
  }

  /**
   * Test {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}.
   *
   * <p>Method under test: {@link PDAppearanceCharacteristicsDictionary#getAlternateIcon()}
   */
  @Test
  @DisplayName("Test getAlternateIcon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject PDAppearanceCharacteristicsDictionary.getAlternateIcon()"
  })
  void testGetAlternateIcon2() {
    // Arrange, Act and Assert
    assertNull(new PDAppearanceCharacteristicsDictionary(new COSStream()).getAlternateIcon());
  }
}
