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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDBoxStyleDiffblueTest {
  /**
   * Test {@link PDBoxStyle#PDBoxStyle(COSDictionary)}.
   *
   * <p>Method under test: {@link PDBoxStyle#PDBoxStyle(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDBoxStyle(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.<init>(COSDictionary)"})
  void testNewPDBoxStyle() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, new PDBoxStyle(dic).getCOSObject());
  }

  /**
   * Test {@link PDBoxStyle#PDBoxStyle()}.
   *
   * <p>Method under test: {@link PDBoxStyle#PDBoxStyle()}
   */
  @Test
  @DisplayName("Test new PDBoxStyle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.<init>()"})
  void testNewPDBoxStyle2() {
    // Arrange and Act
    PDBoxStyle actualPdBoxStyle = new PDBoxStyle();

    // Assert
    PDLineDashPattern lineDashPattern = actualPdBoxStyle.getLineDashPattern();
    assertTrue(lineDashPattern.getCOSObject() instanceof COSArray);
    PDColor guidelineColor = actualPdBoxStyle.getGuidelineColor();
    assertTrue(guidelineColor.getColorSpace() instanceof PDDeviceRGB);
    assertNull(guidelineColor.getPatternName());
    COSDictionary cOSObject = actualPdBoxStyle.getCOSObject();
    assertNull(cOSObject.getKey());
    assertEquals(0, lineDashPattern.getPhase());
    assertEquals(1.0f, actualPdBoxStyle.getGuidelineWidth());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(guidelineColor.isPattern());
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, actualPdBoxStyle.getGuidelineStyle());
    assertArrayEquals(new float[] {0.0f}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, guidelineColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#setGuideLineColor(PDColor)}.
   *
   * <p>Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  @DisplayName("Test setGuideLineColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setGuideLineColor(PDColor)"})
  void testSetGuideLineColor() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    PDColor color = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE);

    // Act
    pdBoxStyle.setGuideLineColor(color);

    // Assert
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f}, pdBoxStyle.getGuidelineColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#setGuideLineColor(PDColor)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  @DisplayName("Test setGuideLineColor(PDColor); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setGuideLineColor(PDColor)"})
  void testSetGuideLineColor_whenNull() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();

    // Act
    pdBoxStyle.setGuideLineColor(null);

    // Assert that nothing has changed
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, pdBoxStyle.getGuidelineColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#setGuideLineColor(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSArray, PDColorSpace)} with array is {@link
   *       COSArray#COSArray()} and colorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setGuideLineColor(PDColor); when PDColor(COSArray, PDColorSpace) with array is COSArray() and colorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setGuideLineColor(PDColor)"})
  void testSetGuideLineColor_whenPDColorWithArrayIsCOSArrayAndColorSpaceIsInstance() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();

    // Act
    pdBoxStyle.setGuideLineColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert that nothing has changed
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, pdBoxStyle.getGuidelineColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#setGuideLineColor(PDColor)}.
   *
   * <ul>
   *   <li>When {@link PDColor#PDColor(COSName, PDColorSpace)} with patternName is {@link COSName#A}
   *       and colorSpace is {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setGuideLineColor(PDColor); when PDColor(COSName, PDColorSpace) with patternName is A and colorSpace is INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setGuideLineColor(PDColor)"})
  void testSetGuideLineColor_whenPDColorWithPatternNameIsAAndColorSpaceIsInstance() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();

    // Act
    pdBoxStyle.setGuideLineColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert that nothing has changed
    assertArrayEquals(
        new float[] {0.0f, 0.0f, 0.0f}, pdBoxStyle.getGuidelineColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()} GuidelineWidth is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  @DisplayName(
      "Test getGuidelineWidth(); given PDBoxStyle() GuidelineWidth is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDBoxStyle.getGuidelineWidth()"})
  void testGetGuidelineWidth_givenPDBoxStyleGuidelineWidthIsOne_thenReturnOne() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuidelineWidth(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdBoxStyle.getGuidelineWidth());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineWidth()}.
   *
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  @DisplayName("Test getGuidelineWidth(); given PDBoxStyle(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDBoxStyle.getGuidelineWidth()"})
  void testGetGuidelineWidth_givenPDBoxStyle_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDBoxStyle().getGuidelineWidth());
  }

  /**
   * Test {@link PDBoxStyle#setGuidelineWidth(float)}.
   *
   * <ul>
   *   <li>Then {@link PDBoxStyle#PDBoxStyle(COSDictionary)} with dic is {@link COSDictionary}
   *       GuidelineWidth is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setGuidelineWidth(float)}
   */
  @Test
  @DisplayName(
      "Test setGuidelineWidth(float); then PDBoxStyle(COSDictionary) with dic is COSDictionary GuidelineWidth is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setGuidelineWidth(float)"})
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
   *
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()} GuidelineStyle is {@link
   *       PDBoxStyle#GUIDELINE_STYLE_SOLID}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  @DisplayName(
      "Test getGuidelineStyle(); given PDBoxStyle() GuidelineStyle is GUIDELINE_STYLE_SOLID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDBoxStyle.getGuidelineStyle()"})
  void testGetGuidelineStyle_givenPDBoxStyleGuidelineStyleIsGuideline_style_solid() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuidelineStyle(PDBoxStyle.GUIDELINE_STYLE_SOLID);

    // Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, pdBoxStyle.getGuidelineStyle());
  }

  /**
   * Test {@link PDBoxStyle#getGuidelineStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDBoxStyle#PDBoxStyle()}.
   *   <li>Then return {@link PDBoxStyle#GUIDELINE_STYLE_SOLID}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  @DisplayName("Test getGuidelineStyle(); given PDBoxStyle(); then return GUIDELINE_STYLE_SOLID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDBoxStyle.getGuidelineStyle()"})
  void testGetGuidelineStyle_givenPDBoxStyle_thenReturnGuideline_style_solid() {
    // Arrange, Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, new PDBoxStyle().getGuidelineStyle());
  }

  /**
   * Test {@link PDBoxStyle#setGuidelineStyle(String)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setName(COSName, String)} does nothing.
   *   <li>Then calls {@link COSDictionary#setName(COSName, String)}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setGuidelineStyle(String)}
   */
  @Test
  @DisplayName(
      "Test setGuidelineStyle(String); given COSDictionary setName(COSName, String) does nothing; then calls setName(COSName, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setGuidelineStyle(String)"})
  void testSetGuidelineStyle_givenCOSDictionarySetNameDoesNothing_thenCallsSetName() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    new PDBoxStyle(dic).setGuidelineStyle("Style");

    // Assert that nothing has changed
    verify(dic).setName(isA(COSName.class), eq("Style"));
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setItem(COSName, COSBase)} does nothing.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setLineDashPattern(COSArray); given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setLineDashPattern(COSArray)"})
  void testSetLineDashPattern_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    // Act
    new PDBoxStyle(dic).setLineDashPattern(mock(COSArray.class));

    // Assert
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName("Test setLineDashPattern(COSArray); then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setLineDashPattern(COSArray)"})
  void testSetLineDashPattern_thenCallsGetKey() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();

    COSArray dashArray = mock(COSArray.class);
    when(dashArray.isDirect()).thenReturn(false);
    when(dashArray.getKey()).thenReturn(null);
    when(dashArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    // Act
    pdBoxStyle.setLineDashPattern(dashArray);

    // Assert
    verify(dashArray).getUpdateState();
    verify(dashArray).getKey();
    verify(dashArray).isDirect();
  }

  /**
   * Test {@link PDBoxStyle#setLineDashPattern(COSArray)}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setLineDashPattern(COSArray); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDBoxStyle.setLineDashPattern(COSArray)"})
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
