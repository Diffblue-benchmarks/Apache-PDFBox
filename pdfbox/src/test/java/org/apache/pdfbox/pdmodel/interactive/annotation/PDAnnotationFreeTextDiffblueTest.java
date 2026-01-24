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
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCircleAppearanceHandler;
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
   *   <li>When minus one hundred.
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} Q is minus one hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#setQ(int)}
   */
  @Test
  @DisplayName(
      "Test setQ(int); when minus one hundred; then PDAnnotationFreeText() Q is minus one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.setQ(int)"})
  void testSetQ_whenMinusOneHundred_thenPDAnnotationFreeTextQIsMinusOneHundred() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();

    // Act
    pdAnnotationFreeText.setQ(-100);

    // Assert
    assertEquals(-100, pdAnnotationFreeText.getQ());
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
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
    pdAnnotationFreeText.setRectDifference(PDRectangle.A0);

    // Assert
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(1, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    PDRectangle rectDifference = pdAnnotationFreeText.getRectDifference();
    assertEquals(3370.3938f, rectDifference.getHeight());
    assertEquals(2383.937f, rectDifference.getUpperRightX());
    assertEquals(3370.3938f, rectDifference.getUpperRightY());
    assertEquals(2383.937f, rectDifference.getWidth());
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 2383.937f, 3370.3938f},
        pdAnnotationFreeText.getRectDifferences(),
        0.0f);
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
  void testSetRectDifference2() {
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
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    byte[] byteArray2 = new byte[51];
    assertEquals(
        51, appearance.getDownAppearance().getAppearanceStream().getContents().read(byteArray2));
    byte[] byteArray3 = new byte[51];
    assertEquals(
        51, appearance.getNormalAppearance().getAppearanceStream().getContents().read(byteArray3));
    byte[] byteArray4 = new byte[51];
    assertEquals(
        51,
        appearance.getRolloverAppearance().getAppearanceStream().getContents().read(byteArray4));
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray2);
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray3);
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray4);
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2382.937 3369.3938 re\nS\n1 0 0 1 0 0".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances2() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(PDRectangle.A1);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess.available());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances3() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(PDRectangle.A1);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(126, contentsForStreamParsing.available());
    assertEquals(126, contentsForRandomAccess.available());
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances4() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("");
    pdAnnotationFreeText.setRectangle(PDRectangle.A1);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(100, normalAppearanceStream.getStream().getLength());
    assertEquals(100, normalAppearanceStream.getContentStream().getLength());
    assertEquals(100L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(119, contentsForStreamParsing.available());
    assertEquals(119, contentsForRandomAccess.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances5() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(109, contentsForStreamParsing.available());
    assertEquals(109, contentsForRandomAccess.available());
    assertEquals(93, normalAppearanceStream.getStream().getLength());
    assertEquals(93, normalAppearanceStream.getContentStream().getLength());
    assertEquals(93L, normalAppearanceStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances6() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(75, contentsForStreamParsing.available());
    assertEquals(75, contentsForRandomAccess.available());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances7() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText(new COSDictionary());
    pdAnnotationFreeText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances8() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(112, contentsForStreamParsing.available());
    assertEquals(112, contentsForRandomAccess.available());
    assertEquals(2.14748365E9f, normalAppearanceStream.getBBox().getUpperRightX());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertEquals(97, normalAppearanceStream.getStream().getLength());
    assertEquals(97, normalAppearanceStream.getContentStream().getLength());
    assertEquals(97L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances9() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(-9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(140, contentsForStreamParsing.available());
    assertEquals(140, contentsForRandomAccess.available());
    assertEquals(2.14748365E9f, normalAppearanceStream.getMatrix().getTranslateX());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertEquals(96, normalAppearanceStream.getStream().getLength());
    assertEquals(96, normalAppearanceStream.getContentStream().getLength());
    assertEquals(96L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals(
        "0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForRandomAccess.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    PDDocument document = new PDDocument();
    document.addPage(new PDPage());

    // Act
    pdAnnotationFreeText.constructAppearances(document);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    List<? extends COSBase> toListResult = normalAppearanceStream.getBBox().getCOSArray().toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    PDAppearanceDictionary appearance = pdAnnotationFreeText.getAppearance();
    assertEquals(
        4,
        appearance
            .getDownAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList()
            .size());
    assertEquals(
        4,
        appearance
            .getNormalAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList()
            .size());
    assertEquals(
        4,
        appearance
            .getRolloverAppearance()
            .getAppearanceStream()
            .getBBox()
            .getCOSArray()
            .toList()
            .size());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument3() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(128, contentsForStreamParsing.available());
    assertEquals(128, contentsForRandomAccess.available());
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument4() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(Float.MAX_EXPONENT, contentsForStreamParsing.available());
    assertEquals(Float.MAX_EXPONENT, contentsForRandomAccess.available());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument5() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("AdobeStandardEncoding");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(123, normalAppearanceStream.getStream().getLength());
    assertEquals(123, normalAppearanceStream.getContentStream().getLength());
    assertEquals(123L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(147, contentsForStreamParsing.available());
    assertEquals(147, contentsForRandomAccess.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument6() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("");
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(100, normalAppearanceStream.getStream().getLength());
    assertEquals(100, normalAppearanceStream.getContentStream().getLength());
    assertEquals(100L, normalAppearanceStream.getCOSObject().getLength());
    assertEquals(120, contentsForStreamParsing.available());
    assertEquals(120, contentsForRandomAccess.available());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument7() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(PDRectangle.A5);

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(125, contentsForStreamParsing.available());
    assertEquals(125, contentsForRandomAccess.available());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(419.52756f, bBox.getUpperRightX());
    assertEquals(419.52756f, bBox.getWidth());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertEquals(595.27563f, bBox.getHeight());
    assertEquals(595.27563f, bBox.getUpperRightY());
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 418.5276 594.2756 re\nS\n1 0 0 1 0 0 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument8() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(109, contentsForStreamParsing.available());
    assertEquals(109, contentsForRandomAccess.available());
    assertEquals(93, normalAppearanceStream.getStream().getLength());
    assertEquals(93, normalAppearanceStream.getContentStream().getLength());
    assertEquals(93L, normalAppearanceStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument9() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("G");
    pdAnnotationFreeText.setRectangle(new PDRectangle(10.0f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    float[][] values = normalAppearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(75, contentsForStreamParsing.available());
    assertEquals(75, contentsForRandomAccess.available());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument10() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler appearanceHandler = new PDCircleAppearanceHandler(annotation);

    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText(new COSDictionary());
    pdAnnotationFreeText.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument());

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument11() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(112, contentsForStreamParsing.available());
    assertEquals(112, contentsForRandomAccess.available());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertEquals(97, normalAppearanceStream.getStream().getLength());
    assertEquals(97, normalAppearanceStream.getContentStream().getLength());
    assertEquals(97L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2147483648 9 re\nS\n1 0 0 1 0 0 cm\n2 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument12() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(-9.223372E18f, 10.0f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(-2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getUpperRightX());
    assertEquals(140, contentsForStreamParsing.available());
    assertEquals(140, contentsForRandomAccess.available());
    assertEquals(2.14748365E9f, normalAppearanceStream.getMatrix().getTranslateX());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertEquals(96, normalAppearanceStream.getStream().getLength());
    assertEquals(96, normalAppearanceStream.getContentStream().getLength());
    assertEquals(96L, normalAppearanceStream.getCOSObject().getLength());
    assertArrayEquals(
        "0 G\n1 w\n-2147483648 0.5 2147483648 9 re\nS\n1 0 0 1 0".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument13() throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setContents("42");
    pdAnnotationFreeText.setRectangle(new PDRectangle(9.223372E18f, 419.52756f));

    // Act
    pdAnnotationFreeText.constructAppearances(null);

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    assertEquals(129, contentsForStreamParsing.available());
    assertEquals(129, contentsForRandomAccess.available());
    PDRectangle bBox = normalAppearanceStream.getBBox();
    assertEquals(419.52756f, bBox.getHeight());
    assertEquals(419.52756f, bBox.getUpperRightY());
    byte[] byteArray = new byte[51];
    assertEquals(51, normalAppearanceStream.getContents().read(byteArray));
    assertArrayEquals(
        "0 G\n1 w\n0.5 0.5 2147483648 418.5276 re\nS\n1 0 0 1 0 ".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSDictionary() {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A0);

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    pdAnnotationFreeText.constructAppearances(new PDDocument(doc));

    // Assert
    float[][] values = pdAnnotationFreeText.getNormalAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
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

  /**
   * Test {@link PDAnnotationFreeText#constructAppearances()}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationFreeText#PDAnnotationFreeText()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationFreeText#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); then PDAnnotationFreeText() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationFreeText.constructAppearances()"})
  void testConstructAppearances_thenPDAnnotationFreeTextCOSObjectValuesSizeIsFour()
      throws IOException {
    // Arrange
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    pdAnnotationFreeText.setRectangle(PDRectangle.A1);

    // Act
    pdAnnotationFreeText.constructAppearances();

    // Assert
    PDAppearanceStream normalAppearanceStream = pdAnnotationFreeText.getNormalAppearanceStream();
    RandomAccessRead contentsForStreamParsing =
        normalAppearanceStream.getContentsForStreamParsing();
    assertTrue(contentsForStreamParsing instanceof RandomAccessReadWriteBuffer);
    RandomAccessRead contentsForRandomAccess = normalAppearanceStream.getContentsForRandomAccess();
    assertTrue(contentsForRandomAccess instanceof RandomAccessReadWriteBuffer);
    COSDictionary cOSObject = pdAnnotationFreeText.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(85, contentsForStreamParsing.available());
    assertEquals(85, contentsForRandomAccess.available());
  }
}
