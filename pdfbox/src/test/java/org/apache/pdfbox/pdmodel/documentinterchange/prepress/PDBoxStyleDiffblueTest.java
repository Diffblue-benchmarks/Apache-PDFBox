package org.apache.pdfbox.pdmodel.documentinterchange.prepress;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDBoxStyleDiffblueTest {
  /**
   * Test {@link PDBoxStyle#PDBoxStyle(COSDictionary)}.
   * <p>
   * Method under test: {@link PDBoxStyle#PDBoxStyle(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDBoxStyle(COSDictionary)")
  void testNewPDBoxStyle() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDBoxStyle(dic)).getCOSObject());
  }

  /**
   * Test {@link PDBoxStyle#PDBoxStyle()}.
   * <p>
   * Method under test: {@link PDBoxStyle#PDBoxStyle()}
   */
  @Test
  @DisplayName("Test new PDBoxStyle()")
  void testNewPDBoxStyle2() {
    // Arrange and Act
    PDBoxStyle actualPdBoxStyle = new PDBoxStyle();

    // Assert
    PDLineDashPattern lineDashPattern = actualPdBoxStyle.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    PDColor guidelineColor = actualPdBoxStyle.getGuidelineColor();
    PDColorSpace colorSpace = guidelineColor.getColorSpace();
    COSBase cOSObject2 = colorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject2).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    COSDictionary cOSObject3 = actualPdBoxStyle.getCOSObject();
    COSUpdateState updateState = cOSObject3.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(guidelineColor.getPatternName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject3.getKey());
    assertNull(cOSObject2.getKey());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(1.0f, actualPdBoxStyle.getGuidelineWidth());
    assertEquals(2, cOSObject3.getValues().size());
    assertEquals(2, cOSObject3.size());
    assertEquals(3, colorSpace.getNumberOfComponents());
    COSIncrement toIncrementResult = cOSObject3.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject3.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(((COSName) cOSObject2).isEmpty());
    assertFalse(cOSObject3.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(guidelineColor.isPattern());
    assertFalse(initialColor.isPattern());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult3).isValid());
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, actualPdBoxStyle.getGuidelineStyle());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, guidelineColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineColor()}.
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineColor()}
   */
  @Test
  @DisplayName("Test getGuidelineColor()")
  void testGetGuidelineColor() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Act
    PDColor actualGuidelineColor = pdBoxStyle.getGuidelineColor();

    // Assert
    PDColorSpace colorSpace = actualGuidelineColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    assertNull(actualGuidelineColor.getPatternName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(actualGuidelineColor.isPattern());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualGuidelineColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineColor()}.
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineColor()}
   */
  @Test
  @DisplayName("Test getGuidelineColor()")
  void testGetGuidelineColor2() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Act
    PDColor actualGuidelineColor = pdBoxStyle.getGuidelineColor();

    // Assert
    PDColorSpace colorSpace = actualGuidelineColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    assertNull(actualGuidelineColor.getPatternName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(actualGuidelineColor.isPattern());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualGuidelineColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineColor()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then ColorSpace COSObject return {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineColor()}
   */
  @Test
  @DisplayName("Test getGuidelineColor(); given COSArray() add FALSE; then ColorSpace COSObject return COSName")
  void testGetGuidelineColor_givenCOSArrayAddFalse_thenColorSpaceCOSObjectReturnCOSName() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    PDColor color = new PDColor(array, PDDeviceGray.INSTANCE);

    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(color);

    // Act
    PDColor actualGuidelineColor = pdBoxStyle.getGuidelineColor();

    // Assert
    PDColorSpace colorSpace = actualGuidelineColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    assertNull(actualGuidelineColor.getPatternName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(actualGuidelineColor.isPattern());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualGuidelineColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineColor()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()}.</li>
   *   <li>Then ColorSpace COSObject return {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineColor()}
   */
  @Test
  @DisplayName("Test getGuidelineColor(); given PDBoxStyle(); then ColorSpace COSObject return COSName")
  void testGetGuidelineColor_givenPDBoxStyle_thenColorSpaceCOSObjectReturnCOSName() {
    // Arrange and Act
    PDColor actualGuidelineColor = (new PDBoxStyle()).getGuidelineColor();

    // Assert
    PDColorSpace colorSpace = actualGuidelineColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    assertNull(actualGuidelineColor.getPatternName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(actualGuidelineColor.isPattern());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualGuidelineColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#setGuideLineColor(PDColor)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  @DisplayName("Test setGuideLineColor(PDColor); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  void testSetGuideLineColor_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDBoxStyle pdBoxStyle = new PDBoxStyle(dic);
    COSArray array = mock(COSArray.class);
    when(array.isEmpty()).thenReturn(true);
    when(array.size()).thenReturn(3);
    when(array.get(anyInt())).thenReturn(COSBoolean.FALSE);

    // Act
    pdBoxStyle.setGuideLineColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(array, atLeast(1)).get(anyInt());
    verify(array).isEmpty();
    verify(array).size();
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDBoxStyle#setGuideLineColor(PDColor)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSArray} {@link COSArray#isEmpty()} return
   * {@code true}.</li>
   *   <li>Then calls {@link COSArray#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  @DisplayName("Test setGuideLineColor(PDColor); given 'true'; when COSArray isEmpty() return 'true'; then calls get(int)")
  void testSetGuideLineColor_givenTrue_whenCOSArrayIsEmptyReturnTrue_thenCallsGet() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSArray array = mock(COSArray.class);
    when(array.isEmpty()).thenReturn(true);
    when(array.size()).thenReturn(3);
    when(array.get(anyInt())).thenReturn(COSBoolean.FALSE);

    // Act
    pdBoxStyle.setGuideLineColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(array, atLeast(1)).get(anyInt());
    verify(array).isEmpty();
    verify(array).size();
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineWidth()}.
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  @DisplayName("Test getGuidelineWidth()")
  void testGetGuidelineWidth() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Act and Assert
    assertEquals(1.0f, pdBoxStyle.getGuidelineWidth());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineWidth()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()} GuidelineWidth is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  @DisplayName("Test getGuidelineWidth(); given PDBoxStyle() GuidelineWidth is one; then return one")
  void testGetGuidelineWidth_givenPDBoxStyleGuidelineWidthIsOne_thenReturnOne() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuidelineWidth(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdBoxStyle.getGuidelineWidth());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineWidth()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  @DisplayName("Test getGuidelineWidth(); given PDBoxStyle(); then return one")
  void testGetGuidelineWidth_givenPDBoxStyle_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDBoxStyle()).getGuidelineWidth());
  }

  /**
   * Test {@link PDBoxStyle#setGuidelineWidth(float)}.
   * <ul>
   *   <li>Then {@link PDBoxStyle#PDBoxStyle(COSDictionary)} with dic is
   * {@link COSDictionary} GuidelineWidth is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setGuidelineWidth(float)}
   */
  @Test
  @DisplayName("Test setGuidelineWidth(float); then PDBoxStyle(COSDictionary) with dic is COSDictionary GuidelineWidth is zero")
  void testSetGuidelineWidth_thenPDBoxStyleWithDicIsCOSDictionaryGuidelineWidthIsZero() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setFloat(Mockito.<COSName>any(), anyFloat());
    PDBoxStyle pdBoxStyle = new PDBoxStyle(dic);

    // Act
    pdBoxStyle.setGuidelineWidth(10.0f);

    // Assert that nothing has changed
    verify(dic).setFloat(isA(COSName.class), eq(10.0f));
    assertEquals(0.0f, pdBoxStyle.getGuidelineWidth());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineStyle()}.
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  @DisplayName("Test getGuidelineStyle()")
  void testGetGuidelineStyle() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, pdBoxStyle.getGuidelineStyle());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineStyle()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()} GuidelineStyle is
   * {@link PDBoxStyle#GUIDELINE_STYLE_SOLID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  @DisplayName("Test getGuidelineStyle(); given PDBoxStyle() GuidelineStyle is GUIDELINE_STYLE_SOLID")
  void testGetGuidelineStyle_givenPDBoxStyleGuidelineStyleIsGuideline_style_solid() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuidelineStyle(PDBoxStyle.GUIDELINE_STYLE_SOLID);

    // Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, pdBoxStyle.getGuidelineStyle());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineStyle()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()}.</li>
   *   <li>Then return {@link PDBoxStyle#GUIDELINE_STYLE_SOLID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  @DisplayName("Test getGuidelineStyle(); given PDBoxStyle(); then return GUIDELINE_STYLE_SOLID")
  void testGetGuidelineStyle_givenPDBoxStyle_thenReturnGuideline_style_solid() {
    // Arrange, Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, (new PDBoxStyle()).getGuidelineStyle());
  }

  /**
   * Test {@link PDBoxStyle#setGuidelineStyle(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setName(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setGuidelineStyle(String)}
   */
  @Test
  @DisplayName("Test setGuidelineStyle(String); given COSDictionary setName(COSName, String) does nothing; then calls setName(COSName, String)")
  void testSetGuidelineStyle_givenCOSDictionarySetNameDoesNothing_thenCallsSetName() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDBoxStyle(dic)).setGuidelineStyle("Style");

    // Assert that nothing has changed
    verify(dic).setName(isA(COSName.class), eq("Style"));
  }

  /**
   * Test {@link PDBoxStyle#getLineDashPattern()}.
   * <p>
   * Method under test: {@link PDBoxStyle#getLineDashPattern()}
   */
  @Test
  @DisplayName("Test getLineDashPattern()")
  void testGetLineDashPattern() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Act
    PDLineDashPattern actualLineDashPattern = pdBoxStyle.getLineDashPattern();

    // Assert
    COSBase cOSObject = actualLineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0, actualLineDashPattern.getPhase());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertTrue(((COSInteger) getResult3).isValid());
    assertArrayEquals(new float[]{0.0f}, actualLineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getLineDashPattern()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()} LineDashPattern is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getLineDashPattern()}
   */
  @Test
  @DisplayName("Test getLineDashPattern(); given PDBoxStyle() LineDashPattern is COSArray()")
  void testGetLineDashPattern_givenPDBoxStyleLineDashPatternIsCOSArray() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setLineDashPattern(new COSArray());

    // Act
    PDLineDashPattern actualLineDashPattern = pdBoxStyle.getLineDashPattern();

    // Assert
    COSBase cOSObject = actualLineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0, actualLineDashPattern.getPhase());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertTrue(((COSInteger) getResult3).isValid());
    assertArrayEquals(new float[]{0.0f}, actualLineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getLineDashPattern()}.
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()}.</li>
   *   <li>Then return COSObject toList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#getLineDashPattern()}
   */
  @Test
  @DisplayName("Test getLineDashPattern(); given PDBoxStyle(); then return COSObject toList size is two")
  void testGetLineDashPattern_givenPDBoxStyle_thenReturnCOSObjectToListSizeIsTwo() {
    // Arrange and Act
    PDLineDashPattern actualLineDashPattern = (new PDBoxStyle()).getLineDashPattern();

    // Assert
    COSBase cOSObject = actualLineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSInteger);
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0, actualLineDashPattern.getPhase());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertTrue(((COSInteger) getResult3).isValid());
    assertArrayEquals(new float[]{0.0f}, actualLineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  void testSetLineDashPattern_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    (new PDBoxStyle(dic)).setLineDashPattern(mock(COSArray.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   * <ul>
   *   <li>Given {@link COSUpdateState#COSUpdateState(COSUpdateInfo)} with
   * updateInfo is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray); given COSUpdateState(COSUpdateInfo) with updateInfo is COSArray()")
  void testSetLineDashPattern_givenCOSUpdateStateWithUpdateInfoIsCOSArray() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSArray dashArray = mock(COSArray.class);
    when(dashArray.isDirect()).thenReturn(true);
    when(dashArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    // Act
    pdBoxStyle.setLineDashPattern(dashArray);

    // Assert
    verify(dashArray).getUpdateState();
    verify(dashArray).isDirect();
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray); given 'false'; then calls getKey()")
  void testSetLineDashPattern_givenFalse_thenCallsGetKey() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSArray dashArray = mock(COSArray.class);
    when(dashArray.isDirect()).thenReturn(false);
    when(dashArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    // Act
    pdBoxStyle.setLineDashPattern(dashArray);

    // Assert
    verify(dashArray, atLeast(1)).getKey();
    verify(dashArray).isDirect();
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray); then calls setOriginDocumentState(COSDocumentState)")
  void testSetLineDashPattern_thenCallsSetOriginDocumentState() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray dashArray = mock(COSArray.class);
    when(dashArray.isDirect()).thenReturn(true);
    when(dashArray.getUpdateState()).thenReturn(cosUpdateState);

    // Act
    pdBoxStyle.setLineDashPattern(dashArray);

    // Assert
    verify(dashArray).getUpdateState();
    verify(dashArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
  }
}
