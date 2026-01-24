package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceCMYK;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

class PDAnnotationPolylineDiffblueTest {
  /**
   * Test {@link PDAnnotationPolyline#PDAnnotationPolyline()}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#PDAnnotationPolyline()}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolyline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.<init>()"})
  void testNewPDAnnotationPolyline() throws IOException {
    // Arrange and Act
    PDAnnotationPolyline actualPdAnnotationPolyline = new PDAnnotationPolyline();

    // Assert
    assertNull(actualPdAnnotationPolyline.getVertices());
    assertNull(actualPdAnnotationPolyline.getAnnotationName());
    assertNull(actualPdAnnotationPolyline.getContents());
    assertNull(actualPdAnnotationPolyline.getModifiedDate());
    assertNull(actualPdAnnotationPolyline.getIntent());
    assertNull(actualPdAnnotationPolyline.getRichContents());
    assertNull(actualPdAnnotationPolyline.getSubject());
    assertNull(actualPdAnnotationPolyline.getTitlePopup());
    assertNull(actualPdAnnotationPolyline.getCreationDate());
    assertNull(actualPdAnnotationPolyline.getAppearanceState());
    assertNull(actualPdAnnotationPolyline.getPage());
    assertNull(actualPdAnnotationPolyline.getRectangle());
    assertNull(actualPdAnnotationPolyline.getOptionalContent());
    assertNull(actualPdAnnotationPolyline.getColor());
    assertNull(actualPdAnnotationPolyline.getInteriorColor());
    assertNull(actualPdAnnotationPolyline.getInReplyTo());
    assertNull(actualPdAnnotationPolyline.getPopup());
    assertNull(actualPdAnnotationPolyline.getAppearance());
    assertNull(actualPdAnnotationPolyline.getNormalAppearanceStream());
    assertNull(actualPdAnnotationPolyline.getBorderStyle());
    assertNull(actualPdAnnotationPolyline.getExternalData());
    assertEquals(-1, actualPdAnnotationPolyline.getStructParent());
    assertEquals(0, actualPdAnnotationPolyline.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationPolyline.getConstantOpacity());
    assertFalse(actualPdAnnotationPolyline.isHidden());
    assertFalse(actualPdAnnotationPolyline.isInvisible());
    assertFalse(actualPdAnnotationPolyline.isLocked());
    assertFalse(actualPdAnnotationPolyline.isLockedContents());
    assertFalse(actualPdAnnotationPolyline.isNoRotate());
    assertFalse(actualPdAnnotationPolyline.isNoView());
    assertFalse(actualPdAnnotationPolyline.isNoZoom());
    assertFalse(actualPdAnnotationPolyline.isPrinted());
    assertFalse(actualPdAnnotationPolyline.isReadOnly());
    assertFalse(actualPdAnnotationPolyline.isToggleNoView());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationPolyline.getEndPointEndingStyle());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationPolyline.getStartPointEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationPolyline.getReplyType());
    assertEquals(PDAnnotationPolyline.SUB_TYPE, actualPdAnnotationPolyline.getSubtype());
  }

  /**
   * Test {@link PDAnnotationPolyline#PDAnnotationPolyline(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Vertices is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#PDAnnotationPolyline(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationPolyline(COSDictionary); when COSDictionary(); then return Vertices is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.<init>(COSDictionary)"})
  void testNewPDAnnotationPolyline_whenCOSDictionary_thenReturnVerticesIsNull() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationPolyline actualPdAnnotationPolyline = new PDAnnotationPolyline(dict);

    // Assert
    assertNull(actualPdAnnotationPolyline.getVertices());
    assertNull(actualPdAnnotationPolyline.getAnnotationName());
    assertNull(actualPdAnnotationPolyline.getContents());
    assertNull(actualPdAnnotationPolyline.getModifiedDate());
    assertNull(actualPdAnnotationPolyline.getSubtype());
    assertNull(actualPdAnnotationPolyline.getIntent());
    assertNull(actualPdAnnotationPolyline.getRichContents());
    assertNull(actualPdAnnotationPolyline.getSubject());
    assertNull(actualPdAnnotationPolyline.getTitlePopup());
    assertNull(actualPdAnnotationPolyline.getCreationDate());
    assertNull(actualPdAnnotationPolyline.getAppearanceState());
    assertNull(actualPdAnnotationPolyline.getPage());
    assertNull(actualPdAnnotationPolyline.getRectangle());
    assertNull(actualPdAnnotationPolyline.getOptionalContent());
    assertNull(actualPdAnnotationPolyline.getColor());
    assertNull(actualPdAnnotationPolyline.getInteriorColor());
    assertNull(actualPdAnnotationPolyline.getInReplyTo());
    assertNull(actualPdAnnotationPolyline.getPopup());
    assertNull(actualPdAnnotationPolyline.getAppearance());
    assertNull(actualPdAnnotationPolyline.getNormalAppearanceStream());
    assertNull(actualPdAnnotationPolyline.getBorderStyle());
    assertNull(actualPdAnnotationPolyline.getExternalData());
    assertEquals(-1, actualPdAnnotationPolyline.getStructParent());
    assertEquals(0, actualPdAnnotationPolyline.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationPolyline.getConstantOpacity());
    assertFalse(actualPdAnnotationPolyline.isHidden());
    assertFalse(actualPdAnnotationPolyline.isInvisible());
    assertFalse(actualPdAnnotationPolyline.isLocked());
    assertFalse(actualPdAnnotationPolyline.isLockedContents());
    assertFalse(actualPdAnnotationPolyline.isNoRotate());
    assertFalse(actualPdAnnotationPolyline.isNoView());
    assertFalse(actualPdAnnotationPolyline.isNoZoom());
    assertFalse(actualPdAnnotationPolyline.isPrinted());
    assertFalse(actualPdAnnotationPolyline.isReadOnly());
    assertFalse(actualPdAnnotationPolyline.isToggleNoView());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationPolyline.getEndPointEndingStyle());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationPolyline.getStartPointEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationPolyline.getReplyType());
    assertSame(dict, actualPdAnnotationPolyline.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle2() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationPolyline.getStartPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} StartPointEndingStyle is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setStartPointEndingStyle(String); then PDAnnotationPolyline() StartPointEndingStyle is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setStartPointEndingStyle(String)"})
  void testSetStartPointEndingStyle_thenPDAnnotationPolylineStartPointEndingStyleIs42() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#getStartPointEndingStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationPolyline.getStartPointEndingStyle()"})
  void testGetStartPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, new PDAnnotationPolyline().getStartPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} EndPointEndingStyle is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then PDAnnotationPolyline() EndPointEndingStyle is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenPDAnnotationPolylineEndPointEndingStyleIs42() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} EndPointEndingStyle is {@link
   *       PDAnnotationLine#LE_NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then PDAnnotationPolyline() EndPointEndingStyle is LE_NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenPDAnnotationPolylineEndPointEndingStyleIsLe_none() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationPolyline.getEndPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} EndPointEndingStyle is {@code
   *       Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setEndPointEndingStyle(String); then PDAnnotationPolyline() EndPointEndingStyle is 'Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setEndPointEndingStyle(String)"})
  void testSetEndPointEndingStyle_thenPDAnnotationPolylineEndPointEndingStyleIsStyle() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#getEndPointEndingStyle()}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAnnotationPolyline.getEndPointEndingStyle()"})
  void testGetEndPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, new PDAnnotationPolyline().getEndPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setInteriorColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} InteriorColor Pattern.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationPolyline() InteriorColor Pattern")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationPolylineInteriorColorPattern() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[] {0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolyline#setInteriorColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} InteriorColor PatternName is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setInteriorColor(PDColor); then PDAnnotationPolyline() InteriorColor PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationPolylineInteriorColorPatternNameIsNull() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[] {}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolyline#getInteriorColor()}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAnnotationPolyline.getInteriorColor()"})
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPolyline().getInteriorColor());
  }

  /**
   * Test {@link PDAnnotationPolyline#getVertices()}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationPolyline.getVertices()"})
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPolyline().getVertices());
  }

  /**
   * Test {@link PDAnnotationPolyline#setVertices(float[])}.
   *
   * <p>Method under test: {@link PDAnnotationPolyline#setVertices(float[])}
   */
  @Test
  @DisplayName("Test setVertices(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.setVertices(float[])"})
  void testSetVertices() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setVertices(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray getObject(int) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArrayGetObjectReturnFalse() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(ArgumentMatchers.anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getObject(0);
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray size() return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenCOSArraySizeReturnThree() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(ArgumentMatchers.anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(ArgumentMatchers.anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsToFloatArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(ArgumentMatchers.anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(ArgumentMatchers.anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(ArgumentMatchers.anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray).getObject(0);
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(ArgumentMatchers.anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(ArgumentMatchers.anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.
   *   <li>Then calls {@link COSArray#getUpdateState()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray size() return three; then calls getUpdateState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances()"})
  void testConstructAppearances_givenCOSArraySizeReturnThree_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances()"})
  void testConstructAppearances_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls toFloatArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolyline.constructAppearances()"})
  void testConstructAppearances_thenCallsToFloatArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(ArgumentMatchers.anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(ArgumentMatchers.anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }
}
