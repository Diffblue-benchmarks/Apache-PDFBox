package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationFreeTextDiffblueTest {
  /**
   * Test {@link PDAnnotationFreeText#PDAnnotationFreeText()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#PDAnnotationFreeText()}
   */
  @Test
  @DisplayName("Test new PDAnnotationFreeText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.<init>()"})
  void testNewPDAnnotationFreeText() throws IOException {
    // Arrange and Act
    PDAnnotationFreeText actualPdAnnotationFreeText = new PDAnnotationFreeText();

    // Assert
    assertNull(actualPdAnnotationFreeText.getCallout());
    assertNull(actualPdAnnotationFreeText.getAnnotationName());
    assertNull(actualPdAnnotationFreeText.getContents());
    assertNull(actualPdAnnotationFreeText.getModifiedDate());
    assertNull(actualPdAnnotationFreeText.getDefaultAppearance());
    assertNull(actualPdAnnotationFreeText.getDefaultStyleString());
    assertNull(actualPdAnnotationFreeText.getIntent());
    assertNull(actualPdAnnotationFreeText.getRichContents());
    assertNull(actualPdAnnotationFreeText.getSubject());
    assertNull(actualPdAnnotationFreeText.getTitlePopup());
    assertNull(actualPdAnnotationFreeText.getCreationDate());
    assertNull(actualPdAnnotationFreeText.getAppearanceState());
    assertNull(actualPdAnnotationFreeText.getPage());
    assertNull(actualPdAnnotationFreeText.getRectangle());
    assertNull(actualPdAnnotationFreeText.getRectDifference());
    assertNull(actualPdAnnotationFreeText.getOptionalContent());
    assertNull(actualPdAnnotationFreeText.getColor());
    assertNull(actualPdAnnotationFreeText.getInReplyTo());
    assertNull(actualPdAnnotationFreeText.getPopup());
    assertNull(actualPdAnnotationFreeText.getAppearance());
    assertNull(actualPdAnnotationFreeText.getNormalAppearanceStream());
    assertNull(actualPdAnnotationFreeText.getBorderEffect());
    assertNull(actualPdAnnotationFreeText.getBorderStyle());
    assertNull(actualPdAnnotationFreeText.getExternalData());
    assertEquals(-1, actualPdAnnotationFreeText.getStructParent());
    assertEquals(0, actualPdAnnotationFreeText.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationFreeText.getQ());
    assertEquals(1.0f, actualPdAnnotationFreeText.getConstantOpacity());
    assertFalse(actualPdAnnotationFreeText.isHidden());
    assertFalse(actualPdAnnotationFreeText.isInvisible());
    assertFalse(actualPdAnnotationFreeText.isLocked());
    assertFalse(actualPdAnnotationFreeText.isLockedContents());
    assertFalse(actualPdAnnotationFreeText.isNoRotate());
    assertFalse(actualPdAnnotationFreeText.isNoView());
    assertFalse(actualPdAnnotationFreeText.isNoZoom());
    assertFalse(actualPdAnnotationFreeText.isPrinted());
    assertFalse(actualPdAnnotationFreeText.isReadOnly());
    assertFalse(actualPdAnnotationFreeText.isToggleNoView());
    assertEquals(PDAnnotationFreeText.IT_FREE_TEXT, actualPdAnnotationFreeText.getSubtype());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationFreeText.getLineEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationFreeText.getReplyType());
    assertArrayEquals(new float[] {}, actualPdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#PDAnnotationFreeText(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Callout is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#PDAnnotationFreeText(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationFreeText(COSDictionary); when COSDictionary(); then return Callout is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.<init>(COSDictionary)"})
  void testNewPDAnnotationFreeText_whenCOSDictionary_thenReturnCalloutIsNull() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationFreeText actualPdAnnotationFreeText = new PDAnnotationFreeText(field);

    // Assert
    assertNull(actualPdAnnotationFreeText.getCallout());
    assertNull(actualPdAnnotationFreeText.getAnnotationName());
    assertNull(actualPdAnnotationFreeText.getContents());
    assertNull(actualPdAnnotationFreeText.getModifiedDate());
    assertNull(actualPdAnnotationFreeText.getSubtype());
    assertNull(actualPdAnnotationFreeText.getDefaultAppearance());
    assertNull(actualPdAnnotationFreeText.getDefaultStyleString());
    assertNull(actualPdAnnotationFreeText.getIntent());
    assertNull(actualPdAnnotationFreeText.getRichContents());
    assertNull(actualPdAnnotationFreeText.getSubject());
    assertNull(actualPdAnnotationFreeText.getTitlePopup());
    assertNull(actualPdAnnotationFreeText.getCreationDate());
    assertNull(actualPdAnnotationFreeText.getAppearanceState());
    assertNull(actualPdAnnotationFreeText.getPage());
    assertNull(actualPdAnnotationFreeText.getRectangle());
    assertNull(actualPdAnnotationFreeText.getRectDifference());
    assertNull(actualPdAnnotationFreeText.getOptionalContent());
    assertNull(actualPdAnnotationFreeText.getColor());
    assertNull(actualPdAnnotationFreeText.getInReplyTo());
    assertNull(actualPdAnnotationFreeText.getPopup());
    assertNull(actualPdAnnotationFreeText.getAppearance());
    assertNull(actualPdAnnotationFreeText.getNormalAppearanceStream());
    assertNull(actualPdAnnotationFreeText.getBorderEffect());
    assertNull(actualPdAnnotationFreeText.getBorderStyle());
    assertNull(actualPdAnnotationFreeText.getExternalData());
    assertEquals(-1, actualPdAnnotationFreeText.getStructParent());
    assertEquals(0, actualPdAnnotationFreeText.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationFreeText.getQ());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationFreeText.getConstantOpacity());
    assertFalse(actualPdAnnotationFreeText.isHidden());
    assertFalse(actualPdAnnotationFreeText.isInvisible());
    assertFalse(actualPdAnnotationFreeText.isLocked());
    assertFalse(actualPdAnnotationFreeText.isLockedContents());
    assertFalse(actualPdAnnotationFreeText.isNoRotate());
    assertFalse(actualPdAnnotationFreeText.isNoView());
    assertFalse(actualPdAnnotationFreeText.isNoZoom());
    assertFalse(actualPdAnnotationFreeText.isPrinted());
    assertFalse(actualPdAnnotationFreeText.isReadOnly());
    assertFalse(actualPdAnnotationFreeText.isToggleNoView());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationFreeText.getLineEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationFreeText.getReplyType());
    assertSame(field, actualPdAnnotationFreeText.getCOSObject());
    assertArrayEquals(new float[] {}, actualPdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#getDefaultAppearance()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getDefaultAppearance()}
   */
  @Test
  @DisplayName("Test getDefaultAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationFreeText.getDefaultAppearance()"})
  void testGetDefaultAppearance() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationFreeText().getDefaultAppearance());
  }

  /**
   * Test {@link PDAnnotationFreeText#setDefaultAppearance(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAppearance(String); then PDAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setDefaultAppearance(String)"})
  void testSetDefaultAppearance_thenPDAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setDefaultAppearance(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setDefaultAppearance(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} DefaultAppearance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setDefaultAppearance(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAppearance(String); when '42'; then PDAnnotationFreeText() DefaultAppearance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setDefaultAppearance(String)"})
  void testSetDefaultAppearance_when42_thenPDAnnotationFreeTextDefaultAppearanceIs42() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setDefaultAppearance("42");

    // Assert
    assertEquals("42", pdAnnotationFreeText.getDefaultAppearance());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#getDefaultStyleString()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getDefaultStyleString()}
   */
  @Test
  @DisplayName("Test getDefaultStyleString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationFreeText.getDefaultStyleString()"})
  void testGetDefaultStyleString() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationFreeText().getDefaultStyleString());
  }

  /**
   * Test {@link PDAnnotationFreeText#setDefaultStyleString(String)}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setDefaultStyleString(String)}
   */
  @Test
  @DisplayName("Test setDefaultStyleString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setDefaultStyleString(String)"})
  void testSetDefaultStyleString() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setDefaultStyleString("Default Style String");

    // Assert
    assertEquals("Default Style String", pdAnnotationFreeText.getDefaultStyleString());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setDefaultStyleString(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setDefaultStyleString(String)}
   */
  @Test
  @DisplayName(
      "Test setDefaultStyleString(String); then PDAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setDefaultStyleString(String)"})
  void testSetDefaultStyleString_thenPDAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setDefaultStyleString(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#getQ()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getQ()}
   */
  @Test
  @DisplayName("Test getQ()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDAnnotationFreeText.getQ()"})
  void testGetQ() {
    // Arrange, Act and Assert
    assertEquals(0, new PDAnnotationFreeText().getQ());
  }

  /**
   * Test {@link PDAnnotationFreeText#setQ(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} Q is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setQ(int)}
   */
  @Test
  @DisplayName("Test setQ(int); when MIN_VALUE; then PDAnnotationFreeText() Q is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setQ(int)"})
  void testSetQ_whenMin_value_thenPDAnnotationFreeTextQIsMin_value() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setQ(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdAnnotationFreeText.getQ());
  }

  /**
   * Test {@link PDAnnotationFreeText#setQ(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} Q is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setQ(int)}
   */
  @Test
  @DisplayName("Test setQ(int); when one; then PDAnnotationFreeText() Q is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setQ(int)"})
  void testSetQ_whenOne_thenPDAnnotationFreeTextQIsOne() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setQ(1);

    // Assert
    assertEquals(1, pdAnnotationFreeText.getQ());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifferences(float)} with {@code difference}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setRectDifferences(float)}
   */
  @Test
  @DisplayName("Test setRectDifferences(float) with 'difference'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setRectDifferences(float)"})
  void testSetRectDifferencesWithDifference() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifferences(10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSArray cOSArray = rectDifference.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(
        new float[] {10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifferences(float, float, float, float)} with {@code
   * differenceLeft}, {@code differenceTop}, {@code differenceRight}, {@code differenceBottom}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setRectDifferences(float, float, float,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setRectDifferences(float, float, float, float) with 'differenceLeft', 'differenceTop', 'differenceRight', 'differenceBottom'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setRectDifferences(float, float, float, float)"})
  void testSetRectDifferencesWithDifferenceLeftDifferenceTopDifferenceRightDifferenceBottom() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifferences(10.0f, 10.0f, 10.0f, 10.0f);

    // Assert
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
    assertEquals(0.0f, rectDifference.getHeight());
    assertEquals(0.0f, rectDifference.getWidth());
    assertEquals(10.0f, rectDifference.getLowerLeftX());
    assertEquals(10.0f, rectDifference.getLowerLeftY());
    assertEquals(10.0f, rectDifference.getUpperRightX());
    assertEquals(10.0f, rectDifference.getUpperRightY());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSArray cOSArray = rectDifference.getCOSArray();
    assertEquals(4, cOSArray.toList().size());
    assertSame(cOSArray, rectDifference.getCOSObject());
    assertArrayEquals(
        new float[] {10.0f, 10.0f, 10.0f, 10.0f}, pdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#getRectDifferences()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getRectDifferences()}
   */
  @Test
  @DisplayName("Test getRectDifferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationFreeText.getRectDifferences()"})
  void testGetRectDifferences() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {}, new PDAnnotationFreeText().getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#setCallout(float[])}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setCallout(float[])}
   */
  @Test
  @DisplayName("Test setCallout(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setCallout(float[])"})
  void testSetCallout() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setCallout(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationFreeText.getCallout(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#getCallout()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getCallout()}
   */
  @Test
  @DisplayName("Test getCallout()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationFreeText.getCallout()"})
  void testGetCallout() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationFreeText().getCallout());
  }

  /**
   * Test {@link PDAnnotationFreeText#setLineEndingStyle(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} LineEndingStyle is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setLineEndingStyle(String); when '42'; then PDAnnotationFreeText() LineEndingStyle is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setLineEndingStyle(String)"})
  void testSetLineEndingStyle_when42_thenPDAnnotationFreeTextLineEndingStyleIs42() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setLineEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setLineEndingStyle(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setLineEndingStyle(String); when 'null'; then PDAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setLineEndingStyle(String)"})
  void testSetLineEndingStyle_whenNull_thenPDAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setLineEndingStyle(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationFreeText.getLineEndingStyle());
  }

  /**
   * Test {@link PDAnnotationFreeText#setLineEndingStyle(String)}.
   *
   * <ul>
   *   <li>When {@code Style}.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} LineEndingStyle is {@code
   *       Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setLineEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setLineEndingStyle(String); when 'Style'; then PDAnnotationFreeText() LineEndingStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setLineEndingStyle(String)"})
  void testSetLineEndingStyle_whenStyle_thenPDAnnotationFreeTextLineEndingStyleIsStyle() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setLineEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationFreeText.getLineEndingStyle());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#getLineEndingStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getLineEndingStyle()}
   */
  @Test
  @DisplayName("Test getLineEndingStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationFreeText.getLineEndingStyle()"})
  void testGetLineEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, new PDAnnotationFreeText().getLineEndingStyle());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationFreeText.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationFreeText.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationFreeText.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationFreeText.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); when 'null'; then PDAnnotationFreeText() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenNull_thenPDAnnotationFreeTextCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setBorderEffect(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when PDBorderEffectDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenPDBorderEffectDictionary() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationFreeText.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
  }

  /**
   * Test {@link PDAnnotationFreeText#getBorderEffect()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getBorderEffect()}
   */
  @Test
  @DisplayName("Test getBorderEffect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderEffectDictionary PDAnnotationFreeText.getBorderEffect()"})
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationFreeText().getBorderEffect());
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}
   */
  @Test
  @DisplayName("Test setRectDifference(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setRectDifference(PDRectangle)"})
  void testSetRectDifference() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifference(PDRectangle.A1);

    // Assert
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
    assertEquals(1683.7795f, rectDifference.getUpperRightX());
    assertEquals(1683.7795f, rectDifference.getWidth());
    assertEquals(2383.937f, rectDifference.getHeight());
    assertEquals(2383.937f, rectDifference.getUpperRightY());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 1683.7795f, 2383.937f},
        pdAnnotationFreeText.getRectDifferences(),
        0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject toIncrement Objects
   *       Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setRectDifference(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setRectDifference(PDRectangle); then PDAnnotationFreeText() COSObject toIncrement Objects Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setRectDifference(PDRectangle)"})
  void testSetRectDifference_thenPDAnnotationFreeTextCOSObjectToIncrementObjectsEmpty() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setRectDifference(null);

    // Assert that nothing has changed
    COSIncrement toIncrementResult = pdAnnotationFreeText.getCOSObject().toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[] {}, pdAnnotationFreeText.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#getRectDifference()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#getRectDifference()}
   */
  @Test
  @DisplayName("Test getRectDifference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAnnotationFreeText.getRectDifference()"})
  void testGetRectDifference() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationFreeText().getRectDifference());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; when PDDocument(); then array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_whenPDDocument_thenArrayLengthIsThree() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument());

    // Assert
    float[][] values = pdAnnotationFreeText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }
}
