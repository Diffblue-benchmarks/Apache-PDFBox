package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationLineDiffblueTest {
  /**
   * Test {@link PDAnnotationLine#PDAnnotationLine()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#PDAnnotationLine()}
   */
  @Test
  @DisplayName("Test new PDAnnotationLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.<init>()"})
  void testNewPDAnnotationLine() throws IOException {
    // Arrange and Act
    PDAnnotationLine actualPdAnnotationLine = new PDAnnotationLine();

    // Assert
    assertNull(actualPdAnnotationLine.getAnnotationName());
    assertNull(actualPdAnnotationLine.getContents());
    assertNull(actualPdAnnotationLine.getModifiedDate());
    assertNull(actualPdAnnotationLine.getCaptionPositioning());
    assertNull(actualPdAnnotationLine.getIntent());
    assertNull(actualPdAnnotationLine.getRichContents());
    assertNull(actualPdAnnotationLine.getSubject());
    assertNull(actualPdAnnotationLine.getTitlePopup());
    assertNull(actualPdAnnotationLine.getCreationDate());
    assertNull(actualPdAnnotationLine.getAppearanceState());
    assertNull(actualPdAnnotationLine.getPage());
    assertNull(actualPdAnnotationLine.getRectangle());
    assertNull(actualPdAnnotationLine.getOptionalContent());
    assertNull(actualPdAnnotationLine.getColor());
    assertNull(actualPdAnnotationLine.getInteriorColor());
    assertNull(actualPdAnnotationLine.getInReplyTo());
    assertNull(actualPdAnnotationLine.getPopup());
    assertNull(actualPdAnnotationLine.getAppearance());
    assertNull(actualPdAnnotationLine.getNormalAppearanceStream());
    assertNull(actualPdAnnotationLine.getBorderStyle());
    assertNull(actualPdAnnotationLine.getExternalData());
    assertEquals(-1, actualPdAnnotationLine.getStructParent());
    assertEquals(0, actualPdAnnotationLine.getAnnotationFlags());
    assertEquals(0.0f, actualPdAnnotationLine.getCaptionHorizontalOffset());
    assertEquals(0.0f, actualPdAnnotationLine.getCaptionVerticalOffset());
    assertEquals(0.0f, actualPdAnnotationLine.getLeaderLineExtensionLength());
    assertEquals(0.0f, actualPdAnnotationLine.getLeaderLineLength());
    assertEquals(0.0f, actualPdAnnotationLine.getLeaderLineOffsetLength());
    assertEquals(1.0f, actualPdAnnotationLine.getConstantOpacity());
    assertFalse(actualPdAnnotationLine.isHidden());
    assertFalse(actualPdAnnotationLine.isInvisible());
    assertFalse(actualPdAnnotationLine.isLocked());
    assertFalse(actualPdAnnotationLine.isLockedContents());
    assertFalse(actualPdAnnotationLine.isNoRotate());
    assertFalse(actualPdAnnotationLine.isNoView());
    assertFalse(actualPdAnnotationLine.isNoZoom());
    assertFalse(actualPdAnnotationLine.isPrinted());
    assertFalse(actualPdAnnotationLine.isReadOnly());
    assertFalse(actualPdAnnotationLine.isToggleNoView());
    assertFalse(actualPdAnnotationLine.hasCaption());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationLine.getEndPointEndingStyle());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationLine.getStartPointEndingStyle());
    assertEquals(PDAnnotationLine.SUB_TYPE, actualPdAnnotationLine.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationLine.getReplyType());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 0.0f}, actualPdAnnotationLine.getLine(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLine#PDAnnotationLine(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Line is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#PDAnnotationLine(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationLine(COSDictionary); when COSDictionary(); then return Line is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.<init>(COSDictionary)"})
  void testNewPDAnnotationLine_whenCOSDictionary_thenReturnLineIsNull() throws IOException {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationLine actualPdAnnotationLine = new PDAnnotationLine(field);

    // Assert
    assertNull(actualPdAnnotationLine.getLine());
    assertNull(actualPdAnnotationLine.getAnnotationName());
    assertNull(actualPdAnnotationLine.getContents());
    assertNull(actualPdAnnotationLine.getModifiedDate());
    assertNull(actualPdAnnotationLine.getSubtype());
    assertNull(actualPdAnnotationLine.getCaptionPositioning());
    assertNull(actualPdAnnotationLine.getIntent());
    assertNull(actualPdAnnotationLine.getRichContents());
    assertNull(actualPdAnnotationLine.getSubject());
    assertNull(actualPdAnnotationLine.getTitlePopup());
    assertNull(actualPdAnnotationLine.getCreationDate());
    assertNull(actualPdAnnotationLine.getAppearanceState());
    assertNull(actualPdAnnotationLine.getPage());
    assertNull(actualPdAnnotationLine.getRectangle());
    assertNull(actualPdAnnotationLine.getOptionalContent());
    assertNull(actualPdAnnotationLine.getColor());
    assertNull(actualPdAnnotationLine.getInteriorColor());
    assertNull(actualPdAnnotationLine.getInReplyTo());
    assertNull(actualPdAnnotationLine.getPopup());
    assertNull(actualPdAnnotationLine.getAppearance());
    assertNull(actualPdAnnotationLine.getNormalAppearanceStream());
    assertNull(actualPdAnnotationLine.getBorderStyle());
    assertNull(actualPdAnnotationLine.getExternalData());
    assertEquals(-1, actualPdAnnotationLine.getStructParent());
    assertEquals(0, actualPdAnnotationLine.getAnnotationFlags());
    assertEquals(0.0f, actualPdAnnotationLine.getCaptionHorizontalOffset());
    assertEquals(0.0f, actualPdAnnotationLine.getCaptionVerticalOffset());
    assertEquals(0.0f, actualPdAnnotationLine.getLeaderLineExtensionLength());
    assertEquals(0.0f, actualPdAnnotationLine.getLeaderLineLength());
    assertEquals(0.0f, actualPdAnnotationLine.getLeaderLineOffsetLength());
    assertEquals(1, field.size());
    assertEquals(1.0f, actualPdAnnotationLine.getConstantOpacity());
    assertFalse(actualPdAnnotationLine.isHidden());
    assertFalse(actualPdAnnotationLine.isInvisible());
    assertFalse(actualPdAnnotationLine.isLocked());
    assertFalse(actualPdAnnotationLine.isLockedContents());
    assertFalse(actualPdAnnotationLine.isNoRotate());
    assertFalse(actualPdAnnotationLine.isNoView());
    assertFalse(actualPdAnnotationLine.isNoZoom());
    assertFalse(actualPdAnnotationLine.isPrinted());
    assertFalse(actualPdAnnotationLine.isReadOnly());
    assertFalse(actualPdAnnotationLine.isToggleNoView());
    assertFalse(actualPdAnnotationLine.hasCaption());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationLine.getEndPointEndingStyle());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationLine.getStartPointEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationLine.getReplyType());
    assertSame(field, actualPdAnnotationLine.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationLine#setLine(float[])}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setLine(float[])}
   */
  @Test
  @DisplayName("Test setLine(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setLine(float[])"})
  void testSetLine() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLine(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    assertArrayEquals(new float[] {10.0f, 0.0f, 10.0f, 0.0f}, pdAnnotationLine.getLine(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLine#getLine()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine#PDAnnotationLine(COSDictionary)} with field is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#getLine()}
   */
  @Test
  @DisplayName(
      "Test getLine(); given PDAnnotationLine(COSDictionary) with field is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationLine.getLine()"})
  void testGetLine_givenPDAnnotationLineWithFieldIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLine(new COSDictionary()).getLine());
  }

  /**
   * Test {@link PDAnnotationLine#getLine()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationLine#PDAnnotationLine()}.
   *   <li>Then return array of {@code float} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#getLine()}
   */
  @Test
  @DisplayName(
      "Test getLine(); given PDAnnotationLine(); then return array of float with zero and zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationLine.getLine()"})
  void testGetLine_givenPDAnnotationLine_thenReturnArrayOfFloatWithZeroAndZero() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 0.0f}, new PDAnnotationLine().getLine(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLine#setStartPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} StartPointEndingStyle is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStartPointEndingStyle(String); then PDAnnotationLine() StartPointEndingStyle is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle_thenPDAnnotationLineStartPointEndingStyleIs42() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setStartPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#setStartPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} StartPointEndingStyle is {@link
   *       PDAnnotationLine#LE_NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStartPointEndingStyle(String); then PDAnnotationLine() StartPointEndingStyle is LE_NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle_thenPDAnnotationLineStartPointEndingStyleIsLe_none() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setStartPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationLine.getStartPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationLine#setStartPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} StartPointEndingStyle is {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStartPointEndingStyle(String); then PDAnnotationLine() StartPointEndingStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle_thenPDAnnotationLineStartPointEndingStyleIsStyle() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getStartPointEndingStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationLine.getStartPointEndingStyle()"})
  void testGetStartPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, new PDAnnotationLine().getStartPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationLine#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} EndPointEndingStyle is {@link
   *       PDAnnotationLine#LE_NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then PDAnnotationLine() EndPointEndingStyle is LE_NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenPDAnnotationLineEndPointEndingStyleIsLe_none() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setEndPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationLine.getEndPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationLine#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} EndPointEndingStyle is {@code Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then PDAnnotationLine() EndPointEndingStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenPDAnnotationLineEndPointEndingStyleIsStyle() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} EndPointEndingStyle is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); when '42'; then PDAnnotationLine() EndPointEndingStyle is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_when42_thenPDAnnotationLineEndPointEndingStyleIs42() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setEndPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getEndPointEndingStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationLine.getEndPointEndingStyle()"})
  void testGetEndPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, new PDAnnotationLine().getEndPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationLine#setInteriorColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} InteriorColor Pattern.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationLine() InteriorColor Pattern")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationLineInteriorColorPattern() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setInteriorColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationLine.getInteriorColor();
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[] {0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLine#setInteriorColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} InteriorColor PatternName is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setInteriorColor(PDColor); then PDAnnotationLine() InteriorColor PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationLineInteriorColorPatternNameIsNull() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationLine.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[] {}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationLine#getInteriorColor()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAnnotationLine.getInteriorColor()"})
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLine().getInteriorColor());
  }

  /**
   * Test {@link PDAnnotationLine#setCaption(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then not {@link PDAnnotationLine#PDAnnotationLine()} hasCaption.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaption(boolean)}
   */
  @Test
  @DisplayName("Test setCaption(boolean); when 'false'; then not PDAnnotationLine() hasCaption")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaption(boolean)"})
  void testSetCaption_whenFalse_thenNotPDAnnotationLineHasCaption() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaption(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdAnnotationLine.hasCaption());
  }

  /**
   * Test {@link PDAnnotationLine#setCaption(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} hasCaption.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaption(boolean)}
   */
  @Test
  @DisplayName("Test setCaption(boolean); when 'true'; then PDAnnotationLine() hasCaption")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaption(boolean)"})
  void testSetCaption_whenTrue_thenPDAnnotationLineHasCaption() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaption(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdAnnotationLine.hasCaption());
  }

  /**
   * Test {@link PDAnnotationLine#hasCaption()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#hasCaption()}
   */
  @Test
  @DisplayName("Test hasCaption()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAnnotationLine.hasCaption()"})
  void testHasCaption() {
    // Arrange, Act and Assert
    assertFalse(new PDAnnotationLine().hasCaption());
  }

  /**
   * Test {@link PDAnnotationLine#getLeaderLineLength()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getLeaderLineLength()}
   */
  @Test
  @DisplayName("Test getLeaderLineLength()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDAnnotationLine.getLeaderLineLength()"})
  void testGetLeaderLineLength() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDAnnotationLine().getLeaderLineLength());
  }

  /**
   * Test {@link PDAnnotationLine#setLeaderLineLength(float)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setLeaderLineLength(float)}
   */
  @Test
  @DisplayName("Test setLeaderLineLength(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setLeaderLineLength(float)"})
  void testSetLeaderLineLength() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLeaderLineLength(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getLeaderLineLength());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getLeaderLineExtensionLength()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getLeaderLineExtensionLength()}
   */
  @Test
  @DisplayName("Test getLeaderLineExtensionLength()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDAnnotationLine.getLeaderLineExtensionLength()"})
  void testGetLeaderLineExtensionLength() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDAnnotationLine().getLeaderLineExtensionLength());
  }

  /**
   * Test {@link PDAnnotationLine#setLeaderLineExtensionLength(float)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setLeaderLineExtensionLength(float)}
   */
  @Test
  @DisplayName("Test setLeaderLineExtensionLength(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setLeaderLineExtensionLength(float)"})
  void testSetLeaderLineExtensionLength() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLeaderLineExtensionLength(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getLeaderLineExtensionLength());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getLeaderLineOffsetLength()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getLeaderLineOffsetLength()}
   */
  @Test
  @DisplayName("Test getLeaderLineOffsetLength()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDAnnotationLine.getLeaderLineOffsetLength()"})
  void testGetLeaderLineOffsetLength() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDAnnotationLine().getLeaderLineOffsetLength());
  }

  /**
   * Test {@link PDAnnotationLine#setLeaderLineOffsetLength(float)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setLeaderLineOffsetLength(float)}
   */
  @Test
  @DisplayName("Test setLeaderLineOffsetLength(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setLeaderLineOffsetLength(float)"})
  void testSetLeaderLineOffsetLength() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLeaderLineOffsetLength(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getLeaderLineOffsetLength());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getCaptionPositioning()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getCaptionPositioning()}
   */
  @Test
  @DisplayName("Test getCaptionPositioning()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationLine.getCaptionPositioning()"})
  void testGetCaptionPositioning() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationLine().getCaptionPositioning());
  }

  /**
   * Test {@link PDAnnotationLine#setCaptionPositioning(String)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaptionPositioning(String)}
   */
  @Test
  @DisplayName("Test setCaptionPositioning(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaptionPositioning(String)"})
  void testSetCaptionPositioning() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionPositioning("Caption Positioning");

    // Assert
    assertEquals("Caption Positioning", pdAnnotationLine.getCaptionPositioning());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#setCaptionPositioning(String)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaptionPositioning(String)}
   */
  @Test
  @DisplayName("Test setCaptionPositioning(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaptionPositioning(String)"})
  void testSetCaptionPositioning2() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(new COSDictionary());

    // Act
    pdAnnotationLine.setCaptionPositioning("Caption Positioning");

    // Assert
    assertEquals("Caption Positioning", pdAnnotationLine.getCaptionPositioning());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#setCaptionPositioning(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationLine#PDAnnotationLine()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaptionPositioning(String)}
   */
  @Test
  @DisplayName(
      "Test setCaptionPositioning(String); then PDAnnotationLine() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaptionPositioning(String)"})
  void testSetCaptionPositioning_thenPDAnnotationLineCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionPositioning(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#setCaptionHorizontalOffset(float)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaptionHorizontalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionHorizontalOffset(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaptionHorizontalOffset(float)"})
  void testSetCaptionHorizontalOffset() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getCaptionHorizontalOffset());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getCaptionHorizontalOffset()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getCaptionHorizontalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionHorizontalOffset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDAnnotationLine.getCaptionHorizontalOffset()"})
  void testGetCaptionHorizontalOffset() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDAnnotationLine().getCaptionHorizontalOffset());
  }

  /**
   * Test {@link PDAnnotationLine#setCaptionVerticalOffset(float)}.
   *
   * <p>Method under test: {@link PDAnnotationLine#setCaptionVerticalOffset(float)}
   */
  @Test
  @DisplayName("Test setCaptionVerticalOffset(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.setCaptionVerticalOffset(float)"})
  void testSetCaptionVerticalOffset() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionVerticalOffset(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getCaptionVerticalOffset());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationLine#getCaptionVerticalOffset()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#getCaptionVerticalOffset()}
   */
  @Test
  @DisplayName("Test getCaptionVerticalOffset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDAnnotationLine.getCaptionVerticalOffset()"})
  void testGetCaptionVerticalOffset() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDAnnotationLine().getCaptionVerticalOffset());
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(new COSDictionary());
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(new COSDictionary());
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add A; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddA_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add A; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddA_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSName.A);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSArray());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddCOSDictionary() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSDictionary());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddCOSDictionary2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSDictionary());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddCOSStream() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSStream());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddFalse() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddFalse2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add ONE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddOne_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add ONE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddOne_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSInteger.ONE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray getObject(int) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayGetObjectReturnFalse() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getObject(0);
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray size() return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArraySizeReturnThree() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsToFloatArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add A; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddA_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add A; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddA_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSName.A);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSArray_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSArray_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSArray());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSDictionary(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSDictionary_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSDictionary());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSDictionary(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSDictionary_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSDictionary());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSStream#COSStream()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSStream(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSStream_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSStream());

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add ONE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddOne_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add ONE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddOne_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSInteger.ONE);

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray).getObject(0);
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.
   *   <li>Then calls {@link COSArray#getUpdateState()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray size() return three; then calls getUpdateState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenCOSArraySizeReturnThree_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationLine#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationLine.constructAppearances()"})
  void testConstructAppearances_thenCallsToFloatArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }
}
